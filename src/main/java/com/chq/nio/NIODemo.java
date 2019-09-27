package com.chq.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIODemo {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        // 设置Socket是非阻塞的
        socketChannel.configureBlocking(false);
        // 绑定到5555端口
        socketChannel.bind(new InetSocketAddress(5555));
        // 创建selector
        Selector selector = Selector.open();
        // 为服务器注册接收事件
        // 我们可以创建很多个channel注册到这个selector上
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int count = selector.select();
            // 如果count<=0说明没有channel中有数据过来，那么直接continue进行下一次检查即可
            if (count <= 0) continue;
            // 如果有准备就绪的，所对应的channel就会被返回回来
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterable = selectionKeySet.iterator();
            while (iterable.hasNext()) {
                SelectionKey key = iterable.next();
                if (key.isAcceptable()) {
                    // 如果accept被激活，说明有客户端连接，客户端那边如何发起连接请求呢？
                    SocketChannel newSocketChannel = socketChannel.accept();
                    newSocketChannel.configureBlocking(false);
                    // 为客户端连接添注册读事件
                    newSocketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    // 如果读到客户端的数据
                    SocketChannel clientSocket = (SocketChannel) key.channel();
                    // 创建缓冲区
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    clientSocket.read(byteBuffer);
                    System.out.println(new String(byteBuffer.array()));
                    String text = "Hello: " + new String(byteBuffer.array()) + "\r\n";
                    // 将Hello + 客户端数据返回给用户，就是一个echo服务器
                    clientSocket.write(ByteBuffer.wrap(text.getBytes()));
                }
                iterable.remove();
            }
        }
    }
}
