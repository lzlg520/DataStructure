package com.lzlg.stack;

import java.util.Scanner;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack(new LinkedNode(0));
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
                    linkedListStack.list();
                    break;
                case "exit":
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个整数：");
                    int value = scanner.nextInt();
                    linkedListStack.push(value);
                    break;
                case "pop":
                    try {
                        int v = linkedListStack.pop();
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

class LinkedListStack {

    private LinkedNode head;

    public LinkedListStack(LinkedNode head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return head.getNext() == null;
    }

    public void push(int data) {
        LinkedNode node = new LinkedNode(data);
        LinkedNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无数据");
        }
        LinkedNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        int data = temp.getData();
        temp = null;
        return data;
    }

    public void list() {
        LinkedNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.printf("static : %d \n", temp.getData());
        }
    }
}


class LinkedNode {
    private int data;

    private LinkedNode next;

    public LinkedNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}