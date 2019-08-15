package com.lzlg.interview.thread;

/**
 * 线程和进程的区别：
 * 1.进程是系统资源分配和运行的独立单位，一个进程可以包含多个线程
 * 2.每个进程都有专用的内存区域，线程之间是共享进程内的内存空间
 * 3.一个进程崩溃，在保护模式下不会对其他进程产生影响
 * 4.一个线程崩溃，整个进程死掉
 * 5.线程共享内存单元(代码和数据)，通过共享的内存单元实现数据交换，实时通信和必要的同步操作
 */
public class ThreadTest {
    public static void main(String[] args) throws Exception {
        TestRunnable test = new TestRunnable();
        new Thread(test).start();
        new Thread(test).start();
        Thread.sleep(1000);
        System.out.println(test.call());
    }
}

/**
 * 线程几个方法的说明：
 * 1.wait() 使线程处于等待状态，并且释放所持有对象的lock
 * 2.sleep() 使一个正在运行的线程处于阻塞状态
 * 3.notify() 随机唤醒一个等待的线程，唤醒哪个线程由JVM决定
 * 4.notifyAll() 唤醒所有处于等待的线程，并不是给所有唤醒线程一个对象的锁，而是让它们竞争
 */
class TestRunnable implements Runnable {
    private int x;
    private int y;

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < 4; i++) {
                x++;
                y++;

                Thread.sleep(200);

                System.out.println(Thread.currentThread().getName() + " x=" + x + ", y=" + y + " " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized String call() {
        String name = Thread.currentThread().getName();
        return "Hello " + name;
    }
}

class ZZ {
    public static void main(String[] args) {
        new ZZ(); // 线程会一致等待
    }

    ZZ() {
        ZZ a1 = this;
        ZZ a2 = this;
        synchronized (a1) { // 主线程运行到这里，会释放对象的锁，并进入等待池
            // 由于没有其他线程notify该主线程，因此一直处于等待状态
            try {
                a2.wait();
                System.out.println("Hello");
            } catch (InterruptedException e) {
                System.out.println("Good Bye");
            } catch (Exception e) {
                System.out.println("The method is wrong");
            } finally {
                System.out.println("Finally");
            }
        }
        System.out.println("Together");
    }
}

class AA {
    public static void main(String[] args) {
        AAThread thread = new AAThread();
        new Thread(thread).start();
        new Thread(thread).start();
        new Thread(thread).start();
    }
}

class AAThread implements Runnable {
    private int i = 5;

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    if (i > 0 && i != 0) {
                        Thread.sleep(5);

                        System.out.println(Thread.currentThread().getName() + " 运行" + i-- + "次");
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        ThreadC c = new ThreadC();
        b.setName("第一线程");
        c.setName("第二线程");

        c.start();
        System.out.println(Thread.currentThread().getName() + " is start....");
        synchronized (c) {
            try {
                System.out.println("Waiting for b to complete...");
                c.wait();
                System.out.println("Completed. Now back to " + Thread.currentThread().getName());
                b.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is running..");
            for (int i = 0; i < 10; i++) {
                total += i;
            }
            System.out.println("total is " + total);
        }
    }
}

class ThreadC extends Thread {
    int sum = 1;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is running..");
            for (int i = 1; i < 10; i++) {
                sum *= i;
            }
            System.out.println("sum is " + sum);
            notify();
        }
    }
}