package com.chq.algorithm;

import java.util.Scanner;

public class ReversePartLinkedList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        LinkedListNode newHead = new LinkedListNode(-1);
        LinkedListNode pre = newHead;
        for (int i = 0; i < len; i++) {
            int currVal = scan.nextInt();
            LinkedListNode curr = new LinkedListNode(currVal);
            pre.next = curr;
            pre = curr;
        }
        int low = scan.nextInt();
        int high = scan.nextInt();
        pre = newHead;
        LinkedListNode curr = newHead.next;
        int index = 1;
        while (index != low) {
            pre = curr;
            curr = curr.next;
            ++index;
        }
        LinkedListNode tail = curr;
        while (index != high) {
            tail = tail.next;
            ++index;
        }
        LinkedListNode next = tail.next;
        tail.next = null;
        pre.next = null;
        pre.next = reverse(curr);
        curr.next = next;

        LinkedListNode head = newHead.next;
        newHead.next = null;
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