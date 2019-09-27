package com.chq.algorithm;

import java.util.HashMap;

/**
 * @author CHQ
 * 通过HashMap来以O(1)的时间复杂度来快速确定对应key是不是在链表中
 * 然后通过Node来维护一个有序双向链表，通过双向指针来进行连接
 */
public class LRUBySelf {

    // 双向链表节点结构
    private class Node {
        public Node pre;
        public Node next;
        public int key;
        public int val;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
            this.pre = null;
            this.next = null;
        }
    }

    // 双向链表 头部是最老的
    /*
     *我觉得重新设计一下比较好
     * addTail(Node n)直接添加到尾部节点
     * removeHead()移除头节点
     * moveToTail(Node n)将对应节点移动到尾部 三种情况：1.n是头节点  2.n是尾节点  3.n是链表中的一个节点
     */
    private class DoublyLinkedList {
        public Node head;
        public Node tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void moveToTail(Node n) {
            // 将节点移动至尾部
            if (n == null || n == tail) return;
            if (head == n) {
                head = n.next;
                head.pre = null;
            } else {
                n.pre.next = n.next;
                n.next.pre = n.pre;
            }

            tail.next = n;
            n.pre = tail;
            n.next = null;
            tail = tail.next;
        }

        public void addToTail(Node n) {
            if (n == null) return;
            // 添加新的节点
            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                n.pre = tail;
                tail = n;
            }
        }

        public Node removeHead() {
            // 删除头部（最老的）节点
            if (head == null) return null;
            Node n = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.pre = null;
            }
            return n;
        }
    }

    private DoublyLinkedList list;
    private HashMap<Integer, Node> map;
    private int capacity;

    public LRUBySelf(int capacity) {
        this.list = new DoublyLinkedList();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        list.moveToTail(n);
        return n.val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node n = new Node(key, value);
            map.put(key, n);
            list.addToTail(n);

            if (map.size() > capacity) {
                Node rmv = list.removeHead();
                map.remove(rmv.key);
            }
        } else {
            Node n = map.get(key);
            n.val = value;
            list.moveToTail(n);
        }
    }
}
