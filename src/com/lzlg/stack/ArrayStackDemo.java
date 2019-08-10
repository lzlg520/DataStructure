package com.lzlg.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);

        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println("show : 显示栈中的数据");
            System.out.println("exit : 退出程序");
            System.out.println("push : 入栈");
            System.out.println("pop : 出栈");
            System.out.println("请输入您的选择：");
            String in = scanner.next();

            switch (in) {
                case "show":
                    arrayStack.list();
                    break;
                case "exit":
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个整数：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int v = arrayStack.pop();
                        System.out.printf("出栈的数据为：%d \n", v);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        }

        System.out.println("程序退出");
    }
}

class ArrayStack {

    private int maxSize;

    private int[] stack;

    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，不能添加");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，不能取出数据");
        }
        return stack[top--];
    }

    public void list() {
        for (int i = top; i >= 0; i--) {
            System.out.printf("static %d ===>>> %d \n", i, stack[i]);
        }
    }
}