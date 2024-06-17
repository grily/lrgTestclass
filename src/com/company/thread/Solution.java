package com.company.thread;

public class Solution {



    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Printtask("aaaa"));
        Thread t2 = new Thread(new Printtask("bbbb"));
        Thread t3 = new Thread(new Printtask("cccc"));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}


