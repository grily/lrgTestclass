package com.company;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //先将链表连成环 得到链表的元素个数n  双指针 快指针先走n%k 在一起走k
        ListNode fast = head;
        if (head == null || k == 0 || head.next == null) {
            return head;
        }

        // 将单链表连成环 同时计数
        int n = 1;
        while (fast.next != null) {
            fast = fast.next;
            n++;
        }

        k = k % n;
        if (k == 0) {
            return head;
        }

        fast.next = head;

        // 计算真正向右移动的位数k

        k = n-k;

        while (k > 0) {
            fast = fast.next;
            k--;
        }

        ListNode pred = fast.next;
        fast.next = null;

        return pred;

    }

    public ListNode rotateRight1(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;

        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(2);
//        node = node.next;
//        node.next = new ListNode(3);
//        node = node.next;
//        node.next = new ListNode(4);
//        node = node.next;
//        node.next = new ListNode(5);

        Solution s = new Solution();
        s.rotateRight1(head, 1);
    }
}
