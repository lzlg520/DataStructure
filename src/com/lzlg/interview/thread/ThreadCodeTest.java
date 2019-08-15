package com.lzlg.interview.thread;

public class ThreadCodeTest {
    public static void main(String[] args) {
        // 1.内部类实现方式
//        ThreadCodeTest threadCodeTest = new ThreadCodeTest();

        // 2.普通类实现形式
        ThreadCodeTest threadCodeTest = new ThreadCodeTest();

        Runnable increaseRunnable = () -> {
            for (int i = 0; i < 5; i++) {
                threadCodeTest.increase();
            }
        };

        Thread increaseThreadOne = new Thread(increaseRunnable, "自增线程1");
        increaseThreadOne.start();

        Thread increaseThreadTwo = new Thread(increaseRunnable, "自增线程2");
        increaseThreadTwo.start();

        Runnable decreaseRunnable = () -> {
            for (int i = 0; i < 5; i++) {
                threadCodeTest.decrease();
            }
        };

        Thread decreaseThreadOne = new Thread(decreaseRunnable, "自减线程1");
        decreaseThreadOne.start();

        Thread decreaseThreadTwo = new Thread(decreaseRunnable, "自减线程2");
        decreaseThreadTwo.start();

    }

//    public ThreadCodeTest() {
//        IncreaseThread increaseThreadOne = new IncreaseThread("自增线程1");
//        IncreaseThread increaseThreadTwo = new IncreaseThread("自增线程2");
//
//        DecreaseThread decreaseThreadOne = new DecreaseThread("自减线程1");
//        DecreaseThread decreaseThreadTwo = new DecreaseThread("自减线程2");
//
//        increaseThreadOne.start();
//        increaseThreadTwo.start();
//
//        decreaseThreadOne.start();
//        decreaseThreadTwo.start();
//    }

    private int no;

    private synchronized void increase() {
        no++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + no);
    }

    private synchronized void decrease() {
        no--;
        System.out.println(Thread.currentThread().getName() + "-dec:" + no);
    }

    class IncreaseThread extends Thread {

        public IncreaseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                increase();
            }
        }
    }

    class DecreaseThread extends Thread {

        public DecreaseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                decrease();
            }
        }
    }
}