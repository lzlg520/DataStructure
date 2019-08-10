package com.lzlg.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4); // 大小为4，预留一个空间，有效数据为3
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

class CircleArray { // 环形队列，预留一个位置用来保证循环利用
    private int maxSize; // 队列最大长度，不是队列的有效元素个数
    private int front; // 指向队列中的第一个元素
    private int rear; // 指向队列最后一个元素的后一个位置
    private int[] array; // 数组

    CircleArray(int size) { // 构造函数初始化数据
        maxSize = size;
        array = new int[maxSize];
        // 初始化 front = 0; rear = 0;
    }

    /**
     * 判断队列是否满了，此时必须考虑取模，考虑预留的空位
     *
     * @return
     */
    boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空，
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
        // 此时是环形队列，需考虑取模
        array[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 取出队列的数据，先判断队列是否为空，需考虑取模
     *
     * @return
     */
    int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，取出数据失败>>>>>>>");
        }
        int value = array[front];
        front = (front + 1) % maxSize; // 后移一位
        return value;
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
        // 注意这里是front，因为front指向队列头部元素
        return array[front];
    }

    /**
     * 展示数组数据
     */
    void show() {
        if (isEmpty()) {
            System.out.println("队列为空，不能显示数据>>>>>>>>>>");
            return;
        }
        int size = size();
        for (int i = front; i < front + size; i++) {
            int pos = i % maxSize;
            System.out.printf("array[%d]=%d\n", pos, array[pos]);
        }
    }

    /**
     * 有效数据的个数
     *
     * @return
     */
    int size() {
        return (rear + maxSize - front) % maxSize;
    }
}