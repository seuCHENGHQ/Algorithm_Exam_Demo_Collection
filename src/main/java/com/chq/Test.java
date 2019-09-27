package com.chq;

import com.chq.designModel.EnumSingleton;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    FileReader fileReader;

    public static void main(String[] args) {
        /**
         * Stack是线程安全的，其是vector的子类，观察其push,pop,peek都是加锁的
         */
//        Stack<Object> stack = new Stack<>();
//        ArrayList<Object> list = new ArrayList<>();
        /*
         * 不可修改集合类的实现方式就是
         * 重写Collection的add，delete等方法，直接抛出异常
         */
//        Collection<Object> collection = Collections.unmodifiableCollection(list);
//
        /**
         * 线程池，FutureTask所表示的异步计算模型
         */
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
//        threadPool.submit(() -> {
//            System.out.println("hello");
//        });
//        //FutureTask看源码可以看出它实现了Runnable接口，因此可以丢进线程池里面
//        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return 1;
//            }
//        });
//        threadPool.submit(task);
        //futuretask的get方法是一个阻塞的方法，当检测到计算仍未完成的时候，就会使用LockSupport.park()方法进入阻塞状态
//        System.out.println(task.get());
        //适配器模式？
//        Executors.callable(() -> {
//            System.out.println("这是将Runnable对象封装为Callable对象的方法");
//        });
//        ConcurrentHashMap
//        new ThreadPoolExecutor();
//        threadPool.submit(new CallableTest());
//        threadPool.submit(() -> {
//            System.out.println("");
//        });

        /**
         * ReentrantLock是基于队列同步器AQS和LockSupport工具类来实现的
         */
//        ReentrantLock lock = new ReentrantLock();
//        lock.lock();
//        lock.unlock();

//        Character.isDigit('6');
//        System.out.println(Character.isAlphabetic('c'));
//        Scanner scan = new Scanner(System.in);
//        String str = scan.nextLine();
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (Character.isAlphabetic(str.charAt(i))) {
//                int count = 0;
//                while (i + count < str.length() && Character.isAlphabetic(str.charAt(i + count))) {
//                    ++count;
//                }
//                list.add(str.substring(i, i + count));
//                i = i + count;
//            }
//        }
//        System.out.println(list);
//        System.out.println(new String[2]);
//        System.out.println(1 / 3d);
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(1, 2);
//        System.out.println(map);
//        map.remove(1);

        StringBuffer sb = new StringBuffer();
//        System.out.println(map);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Vector<Integer> vector = new Vector<>();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        ConcurrentHashMap<Object, Object> chm = new ConcurrentHashMap<>();
//        Proxy.newProxyInstance()
//        PriorityQueue
//        DecimalFormat format = new DecimalFormat();
//        format.applyPattern("0.00000");
//        System.out.println(format.format(0.5));
//        System.out.println(format.format(0.5));
//        String str = "1 2 3";
//        System.out.println(Arrays.toString(str.split(" ")));
//        System.out.println(Byte.MAX_VALUE);
//        System.out.println(Short.);
        //通过反射机制来创建对象
//        "".getClass().newInstance();
//        System.out.println(Character.isAlphabetic('C'));

//        CallableTest[] arr = new CallableTest[2];
//        Set<Short> set = new TreeSet<>();
//        for (Short k = 0; k < 20; k++) {
//            set.add(k);
//            set.remove(k - 1);
//        }
//        System.out.println(set.size());
        //FutureTask实现了Runnable接口，因此可以直接丢到线程池里面运行
//        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return 1;
//            }
//        });
//        Thread t = new Thread(task);
//        int n = Integer.parseInt("ffff", 16);
//        System.out.println(n);
//        System.out.println("2001::2002".split(":").length);
//        int test = "001".indexOf("0");
//        System.out.println(test);
//        System.out.println(Math.round(-27.2345));
//        System.out.println(Math.ceil(-27.2345));
//        System.out.println(Math.floor(-27.2345));
//        System.out.println(EnumSingleton.SINGLETON);
//        int x = 5;
//        x = ~x;
//        for (int x = 3, y = 0; x > y; x--, y++) {
//            System.out.print(x+);
//        }
//        Object o = Integer.valueOf(2);

//        Long l = (Long) o;
//        System.out.println(Math.round(123456789123456789.12f));
//        float f = 9 / 2;
//        System.out.println(f);
//        byte[] arr = new byte[]{1, 2, 3, 4};
//        for (final int i : arr) {
//            System.out.println(++i);
//        }
//        Long j = (Long) (new Integer(10));
//        System.out.println(-1 >>> 1);
//        System.out.println(-1 >>> 0);
//        System.out.println(-1 >>> 32);
//        System.out.println(-1 >> 1);
//        System.out.println(-1 >>> 32);
//        IOException
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        System.out.println(solution(list));
//        Thread t = new Thread(new ThreadTest());
//        t.start();
//        int [] myarray = {1,2,3};
//        int myarray [] = {1,2,3};
        char test = 1 + '0';
        System.out.println(test);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
    }

    public static List<Integer> solution(List<Integer> list) {
        for (int i = 0; i < list.size(); ) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            } else {
                ++i;
            }
        }
        return list;
    }
}

class CallableTest implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        return null;
    }

    int data;

    void display() {
        System.out.println(data);
    }

    public static void main(String[] args) {
        CallableTest c = new CallableTest();
//        c.display();
        Test t = new Test();
//        t.x = 10;
//        t = new Test();
//        System.out.println(t.x);
    }
}

class ThreadTest extends Thread implements Runnable {
    @Override
    public void run() {
        System.out.println("hello");
    }
}