package com.korsuk.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class MyLock {
    static Long counter = 1L;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new MyTread(reentrantLock));
            t.start();
        }
    }

    static class MyTread implements Runnable {
        ReentrantLock lock;
        public MyTread(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 1; i < 5; i++){
                    System.out.printf("%s %d \n", Thread.currentThread().getName(), MyLock.counter);
                    MyLock.counter++;
                    Thread.sleep(100);
                }
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            finally{
                lock.unlock();
            }
        }
    }
}
