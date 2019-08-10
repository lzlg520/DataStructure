package com.lzlg.linkedlist;

public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();


        circleSingleLinkedList.boyOutCircle(1, 2, 5);
    }
}

class CircleSingleLinkedList {

    private BoyNode first;

    public void build(int nums) {
        if (nums < 1) {
            return;
        }

        BoyNode currentNode = null;
        for (int i = 1; i <= nums; i++) {
            BoyNode boyNode = new BoyNode(i);
            if (i == 1) {
                first = boyNode;
                first.setNext(first);
                currentNode = first;
            } else {
                currentNode.setNext(boyNode);
                boyNode.setNext(first);
                currentNode = boyNode;
            }
        }
    }

    public void boyOutCircle(int start, int count, int nums) {
        if (start < 1 || count < 0 || nums < 1 || start > nums) {
            System.out.println("非法参数");
            return;
        }

        build(nums);

        list();

        BoyNode helper = getLastNode();

        helper = move(start - 1, helper);

        while (true) {
            if(helper == first) {
                break;
            }
            helper = move(count - 1, helper);
            System.out.printf("被移出圈的小孩的编号为：%d \n", first.getNo());

            first = first.getNext();
            helper.setNext(first);
        }

        System.out.printf("最后剩下的小孩的编号为：%d \n", first.getNo());
    }

    private BoyNode getLastNode() {
        BoyNode helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        return helper;
    }

    private BoyNode move(int step, BoyNode helper) {
        for (int i = 0; i < step; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        return helper;
    }

    public void list() {
        BoyNode temp = first;
        while (true) {
            System.out.println(temp);
            if (temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }
    }
}

class BoyNode {
    private int no;

    private BoyNode next;

    public BoyNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "BoyNode{" +
                "no=" + no +
                '}';
    }
}