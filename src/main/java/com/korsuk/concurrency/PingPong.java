package com.korsuk.concurrency;

public class PingPong {
    private static final Object MONITOR = new Object();

    public static void main(String[] args) {

        makeTread("ping").start();
        makeTread("pong").start();
    }

    private static Thread makeTread(String word) {
       return new Thread(() -> {
           synchronized (MONITOR) {
               for (int i = 0; i < 50; i++) {
                   System.out.println(word);
                   try {
                       Thread.sleep(1000);
                       MONITOR.notify();
                       MONITOR.wait();
                   }
                   catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       });
    }
}
