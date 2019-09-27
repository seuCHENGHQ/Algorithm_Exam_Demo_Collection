package com.chq.algorithm;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(-1);
        LinkedListNode curr = head;
        for (int i = 0; i < 5; i++) {
            curr.next = new LinkedListNode(i);
            curr = curr.next;
        }
        head = reverse(head.next);
        curr = head;
        StringBuilder builder = new StringBuilder();
        while (curr != null) {
            builder.append(curr.val);
            builder.append(' ');
            curr = curr.next;
        }
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }

    public static LinkedListNode reverse(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode pre = null;
        LinkedListNode curr = head;
        while (curr != null) {
            LinkedListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}

class LinkedListNode {
    public LinkedListNode next;
    public int val;

    public LinkedListNode(int val) {
        this.val = val;
    }
}
