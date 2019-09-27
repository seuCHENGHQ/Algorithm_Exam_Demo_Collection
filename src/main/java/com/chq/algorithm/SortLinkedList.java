package com.chq.algorithm;

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return mergeSort(head);
        // return quickSort(head);
//        return bubbleSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        //快慢指针来查找链表的中间节点，然后切分为两个链表，再进行归并
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        //找到slow的前一个节点，这一步是必要的，因为如果不取slow的前一个结点的话，当链表中只有2个节点时，会出现死循环
        ListNode prev = head;
        while (prev.next != slow) {
            prev = prev.next;
        }
        prev.next = null;

        ListNode head1 = mergeSort(head);
        ListNode head2 = mergeSort(slow);
        return merge(head1, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        //这里也可以用递归来进行归并
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = null;
        if (head1.val <= head2.val) {
            head = head1;
            ListNode next = head1.next;
            head1.next = null;
            head1 = next;
        } else {
            head = head2;
            ListNode next = head2.next;
            head2.next = null;
            head2 = next;
        }
        head.next = merge(head1, head2);
        return head;
    }

    /**
     * 其实这个不太像快排，而是有点像冒泡排序
     *
     * @param head
     * @return
     */
    public ListNode quickSort(ListNode head) {
        if (head == null) return null;
        ListNode small = new ListNode(-1);
        ListNode smallPointer = small;
        ListNode big = new ListNode(-1);
        ListNode bigPointer = big;

        ListNode hook = head;
        head = hook.next;
        hook.next = null;
        while (head != null) {
            if (head.val <= hook.val) {
                smallPointer.next = head;
                ListNode next = head.next;
                head.next = null;
                head = next;
                smallPointer = smallPointer.next;
            } else {
                bigPointer.next = head;
                ListNode next = head.next;
                head.next = null;
                head = next;
                bigPointer = bigPointer.next;
            }
        }
        small.next = quickSort(small.next);
        big.next = quickSort(big.next);

        ListNode next = null;
        next = small.next;
        small.next = null;
        small = next;

        next = big.next;
        big.next = null;
        big = next;

        head = small;
        while (small != null && small.next != null) {
            small = small.next;
        }
        if (head == null) {
            head = hook;
            hook.next = big;
        } else {
            small.next = hook;
            hook.next = big;
        }

        return head;
    }

    public ListNode bubbleSort(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode next = head.next;
        head.next = null;
        next = bubbleSort(next);

        ListNode prev = null;
        ListNode curr = next;
        while (curr != null && curr.val < head.val) {
            prev = curr;
            curr = curr.next;
        }

        if (prev == null) {
            head.next = curr;
            return head;
        } else {
            ListNode result = next;
            prev.next = head;
            head.next = curr;
            return result;
        }
    }

    /**
     * 快速排序,这里的快速排序其实是交换了链表节点中的值，而不是通过改变next指针的方式来实现排序
     */
    public static void quickSort(ListNode begin, ListNode end) {
        if (begin == null || begin == end)
            return;

        ListNode index = paration(begin, end);
        quickSort(begin, index);
        quickSort(index.next, end);
    }

    /**
     * 划分函数，以头结点值为基准元素进行划分
     *
     * @param begin
     * @param end
     * @return
     */
    public static ListNode paration(ListNode begin, ListNode end) {
        if (begin == null || begin == end)
            return begin;

        int val = begin.val;  //基准元素
        ListNode index = begin, cur = begin.next;

        while (cur != end) {
            if (cur.val < val) {  //交换
                index = index.next;
                int tmp = cur.val;
                cur.val = index.val;
                index.val = tmp;
            }
            cur = cur.next;
        }


        begin.val = index.val;
        index.val = val;

        return index;
    }
}

class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int val) {
        this.val = val;
    }
}