package com.company.thread;

public class ThreadLifecycleExample extends Thread{

    public static int count = 1;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

    }


    public static void main(String[] args) {
        ThreadLifecycleExample threadLifecycleExample = new ThreadLifecycleExample();
        threadLifecycleExample.setName("123");
        threadLifecycleExample.run();
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        ThreadLifecycleExample[] brr = new ThreadLifecycleExample[3];
        brr[0] = threadLifecycleExample;
        brr[1] = threadLifecycleExample;
        brr[2] = threadLifecycleExample;
    }


//    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            public void run() {
//                System.out.println("线程启动");
//                try {
//                    // 睡眠500毫秒
//                    for(int i=0;i<5;i++){
////                        System.out.println(i);
//                        Thread.sleep(1);  // Timed Waiting
//                    }
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("线程结束");
//            }
//        });
//
//        // 打印线程的初始状态
//        System.out.println("线程状态：" + thread.getState()); // NEW
//
//        // 启动线程
//        thread.start();
//
//        // 打印线程就绪和运行状态
//        while(thread.getState() != Thread.State.TERMINATED) {
//            System.out.println("线程状态：" + thread.getState()); // Runnable or Running
////            try {
//////                Thread.sleep(100); // 为了观察状态，每0.1秒查询一次
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//        }
//    }


//    public static void main(String[] args) {
//        // 创建一个对象作为锁
//        Object lock = new Object();
//
//        // 创建一个线程，让它进入TIMED_WAITING状态
//        Thread timedWaitingThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (lock) {
//                    try {
//                        System.out.println("线程进入TIMED_WAITING状态");
//                        Thread.sleep(2); // 让线程等待5秒
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        // 创建一个线程，让它进入BLOCKED状态
//        Thread blockedThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1); // 让线程等待5秒
//                    System.out.println("synchronized之前的状态");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                synchronized (lock) {
//                    try {
//                        System.out.println("线程进入BLOCKED状态");
//                        lock.wait(); // 让线程等待，直到其他线程调用lock.notify()或lock.notifyAll()
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        },"blockedThread");
//
////         启动线程
//        timedWaitingThread.start();
//        // 打印线程就绪和运行状态
//        while(timedWaitingThread.getState() != Thread.State.TERMINATED) {
//            System.out.println("线程状态1：" + timedWaitingThread.getState()); // TIMED_WAITING
//            try {
//                Thread.sleep(100); // 为了观察状态，每0.1秒查询一次
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        blockedThread.start();
//        while(blockedThread.getState() != Thread.State.TERMINATED) {
//            System.out.println("线程状态2：" + blockedThread.getState()); //WAITING
//            try {
//                Thread.sleep(100); // 为了观察状态，每0.1秒查询一次
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

}
