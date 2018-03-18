package com.algorithm.interview;

public class DeadLock {
    private static Object objectA = new Object();
    private static Object objectB = new Object();

    public static void main(String[] args) {
        startTheadA();
        startThreadB();
    }

    private static void startTheadA() {
        new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("startThreadA running!");
                        synchronized (objectA) {
                            System.out.println("startTheadA enter lockA");
                            DeadLock.sleep(1000);
                            synchronized (objectB) {
                                System.out.println("startTheadA enter lockB");
                            }
                        }
                    }
                }
        ).start();
    }

    private static void startThreadB() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("startThreadB running!");
                synchronized (objectB) {
                    System.out.println("startThreadB enter lockA");
                    synchronized (objectA) {
                        System.out.println("startThreadB enter lockB");
                    }
                }
            }
        }).start();
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
