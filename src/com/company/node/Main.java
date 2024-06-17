package com.company.node;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node head = new Node();
        head.value = in.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int value = in.nextInt();
            int next = in.nextInt();
            for (Node p = head; p != null; p = p.next) {
                if (p.value == next) {
                    Node node = new Node();
                    node.value = value;
                    node.next = p.next;
                    p.next = node;
                }
            }
        }
        int m = in.nextInt();
        if (head.value == m) {
            head = head.next;
        } else {
            for (Node p = head; p.next != null; p = p.next) {
                if (p.next.value == m) {
                    p.next = p.next.next;
                }
            }
        }
        for(Node p = head; p != null; p = p.next){
            System.out.print(p.value+" ");
        }
    }
}

class Node {
    int value;
    Node next;
}
