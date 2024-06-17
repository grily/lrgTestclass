package com.company.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Printtask implements Runnable {
    //    锁对象也必须是全局的静态变量 否则不是一个锁对象 也不能控制并发
    private static Object lock = new Object();
//    共享变量必须是类级别的变量 因为他们可以在所有实例对象之间共享，并且只有一份副本存在于内存中
    private static volatile int count = 1;
//private static AtomicInteger count = new AtomicInteger(1);
private String name;
    Printtask(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        synchronized (lock) {
            System.out.println(name + "正在打印：");
                try {
                    // 让线程休眠一段时间，模拟打印过程
                    count++;
//                    count.incrementAndGet();
                    Thread.sleep(10);
                    count--;
//                    count.decrementAndGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println(count);
        }

    }

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


