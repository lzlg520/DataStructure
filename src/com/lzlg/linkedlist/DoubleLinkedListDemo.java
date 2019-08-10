package com.lzlg.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleNode node1 = new DoubleNode(1, "宋江", "及时雨");
        DoubleNode node2 = new DoubleNode(2, "卢俊义", "玉麒麟");
        DoubleNode node3 = new DoubleNode(3, "吴用", "智多星");
        DoubleNode node4 = new DoubleNode(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByNo(node2);
        doubleLinkedList.addByNo(node3);
        doubleLinkedList.addByNo(node1);
        doubleLinkedList.addByNo(node4);
        doubleLinkedList.list();

        DoubleNode newNode = new DoubleNode(3, "吴用666", "智多星Fuck you");

        doubleLinkedList.update(newNode);
        doubleLinkedList.list();

        doubleLinkedList.delete(3);
        doubleLinkedList.list();
    }


}

class DoubleLinkedList {
    DoubleNode head = new DoubleNode(0, "", "");

    public DoubleLinkedList() {
    }

    public void add(DoubleNode node) {
        DoubleNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void addByNo(DoubleNode node) {
        DoubleNode temp = head;
        boolean isExist = false;
        while (temp.next != null) {
            if (temp.next.getNo() > node.getNo()) {
                break;
            } else if (temp.next.getNo() == node.getNo()) {
                isExist = true;
                break;
            }
            temp = temp.next;
        }

        if (isExist) {
            System.out.println("已存在该节点，不能再次添加");
        } else {
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;
        }
    }

    public void update(DoubleNode node) {
        DoubleNode temp = head;
        boolean isFind = false;
        while (temp.next != null) {
            if (temp.next.getNo() == node.getNo()) {
                isFind = true;
                break;
            }
            temp = temp.next;
        }
        if (isFind) {
            temp.next.setName(node.getName());
            temp.next.setNickName(node.getNickName());
        } else {
            System.out.println("Not found");
        }
    }

    public void delete(int no) {
        DoubleNode temp = head;
        if (temp.next == null) {
            return;
        }
        boolean isFind = false;
        while (temp.next != null) {
            if (temp.getNo() == no) {
                isFind = true;
                break;
            }
            temp = temp.next;
        }
        if (isFind) {
            temp.next.pre = temp.pre;
            temp.pre.next = temp.next;
        }
    }

    public void list() {
        DoubleNode temp = head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }
}

class DoubleNode {
    private int no;

    private String name;

    private String nickName;

    DoubleNode pre;

    DoubleNode next;

    public DoubleNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}