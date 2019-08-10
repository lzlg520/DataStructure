package com.lzlg.queue;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 打印队列数据");
            System.out.println("a(add): 向队列添加数据");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 从队列取出头部数据");
            System.out.println("e(exit): 退出循环，结束程序");

            System.out.print("请输入：");
            String input = scanner.next();
            System.out.println();
            switch (input) {
                case "s":
                    queue.show();
                    break;
                case "a":
                    System.out.print("请输入一个数字：");
                    int no = scanner.nextInt();
                    queue.add(no);
                    break;
                case "g":
                    try {
                        int result = queue.get();
                        System.out.printf("取出的数据是：%d\n", result);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case "h":
                    try {
                        int result = queue.head();
                        System.out.printf("取出的数据是：%d\n", result);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序结束>>>>>>>>>");
    }
}

class ArrayQueue {
    private int maxSize; // 队列最大长度
    private int front; // 队列头部的前一个位置，数据取出时移动
    private int rear; // 队列头部的前一个数据（包含数据），数据添加时移动
    private int[] array; // 数组

    ArrayQueue(int size) { // 构造函数初始化数据
        maxSize = size;
        array = new int[maxSize];
        front = -1;
        rear = -1;
    }

    /**
     * 判断队列是否满了，此时rear的值为数组长度减一
     *
     * @return
     */
    boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空，当front和rear相等时
     *
     * @return
     */
    boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加元素，先判断队列是否满了
     *
     * @param n
     */
    void add(int n) {
        if (isFull()) {
            System.out.println("队列已经满了>>>>>>>");
            return;
        }
        rear++;
        array[rear] = n;
    }

    /**
     * 取出队列的数据，先判断队列是否为空
     *
     * @return
     */
    int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，取出数据失败>>>>>>>");
        }
        front++;
        return array[front];
    }

    /**
     * 获取队列头部元素
     *
     * @return
     */
    int head() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，取出头部数据失败>>>>>>");
        }
        // 注意这里是front + 1 ，而不是 front，因为front指向队列头部元素的前一个位置
        return array[front + 1];
    }

    /**
     * 展示数组数据
     */
    void show() {
        if (isEmpty()) {
            System.out.println("队列为空，不能显示数据>>>>>>>>>>");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d\n", i, array[i]);
        }
    }
}