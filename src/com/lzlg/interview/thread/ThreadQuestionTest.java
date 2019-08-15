package com.lzlg.interview.thread;

public class ThreadQuestionTest {
    public static void main(String[] args) {
//        Thread b1 = new BB(500);
//        b1.setName("线程 1");
//
//        Thread b2 = new BB(300);
//        b2.setName("线程 2");
//
//        b1.start();
//        b2.start();

        BBR b1 = new BBR("线程 1", 500);

        BBR b2 = new BBR("线程 2", 300);

    }
}

/**
 * 调用线程 sleep 方法 后 调用 isAlive 方法返回false
 */
class BB extends Thread {
    int time;

    public BB(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i + "次");
                Thread.sleep(time);
                if (i == 5) {
                    System.out.println(Thread.currentThread().getName() + " 退出了");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * sleep方法和wait方法的区别：
 * <p>
 * 1.sleep是线程Thread的静态方法，导致线程暂停执行指定的时间，
 * 把执行机会让给其他线程，但是监控状态依然保持，时间一过自动恢复。
 * 调用sleep方法不会释放对象锁。
 * <p>
 * 2.wait是Object的方法，对此对象调用wait方法会导致本线程放弃对象锁，
 * 进入此对象的等待锁定池。只有对此对象发出notify或notifyAll方法后，
 * 本线程才进入对象锁定池中准备获得对象锁进入运行状态。
 */
class BBR implements Runnable {
    private int time;
    private Thread th;

    public BBR(String name, int time) {
        this.time = time;
        th = new Thread(this, name);
        th.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i + "次");
                Thread.sleep(time);
                if (i == 5) {
                    System.out.println(Thread.currentThread().getName() + " 退出了");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}