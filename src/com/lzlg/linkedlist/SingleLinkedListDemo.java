package com.lzlg.linkedlist;

import java.util.Stack;

/**
 * 单向链表（有头部节点）
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
/*
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByNo(hero3);
        singleLinkedList.addByNo(hero1);
        singleLinkedList.addByNo(hero2);
        singleLinkedList.addByNo(hero4);

        System.out.println("修改链表数据>>>前的链表数据：");
        singleLinkedList.list();
        HeroNode newHeroNode = new HeroNode(3, "lzlg", "性成瘾者");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改链表数据===后的链表数据：");
        singleLinkedList.list();


        singleLinkedList.remove(1);
        System.out.println("删除链表数据+++后的链表数据：");
        singleLinkedList.list();
        System.out.println("===============>>>>>>>>>>>>>>>>>>>");
        System.out.printf("链表的有效节点个数为：%d \n", singleLinkedList.length());
        System.out.println("===============>>>>>>>>>>>>>>>>>>>");
        System.out.printf("获取倒数第 %d 的节点： %s", 2, singleLinkedList.getLastIndexNode(2));
*/
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByNo(hero3);
        singleLinkedList.addByNo(hero1);
        singleLinkedList.addByNo(hero2);
        singleLinkedList.addByNo(hero4);

        singleLinkedList.list();
        System.out.println("===============>>>>>>>>>>>>>>>>>>>");
//        singleLinkedList.reverseList();
//        System.out.println("反转链表之后=====>>>>>>");
//        singleLinkedList.list();

        System.out.println("反转打印链表=====>>>>>>");
        singleLinkedList.reversePrint();
    }

}

class SingleLinkedList {
    // 链表头部元素，只用来指明头部，不可动，所以是final
    final HeroNode head = new HeroNode(0, "", "");

    /**
     * 合并两个有序链表
     *
     * @param orderList
     */
    public void unionOrderList(SingleLinkedList orderList) {
        HeroNode temp1 = head.next;
        HeroNode temp2 = orderList.head.next;
        // 判断链表是否为空
        if(temp1 == null || temp2 == null) {
            return;
        }
        while (temp1.no > temp2.no) {


            temp2 = temp2.next;
        }

    }

    /**
     * 使用栈：先进后出的数据结构实现不反转链表，从而反转打印数据
     */
    public void reversePrint() {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head;
        while ((temp = temp.next) != null) {
            stack.push(temp);
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 反转链表
     */
    public void reverseList() {
        if (head.next == null) { // 判断链表是否为空
            return;
        }
        HeroNode current = head.next; // 存储当前链表的元素
        HeroNode currentNext = null; // 当前链表元素的下一个元素
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (current != null) {
            currentNext = current.next; // 存储当前链表的下一个元素
            current.next = reverseHead.next; // 将当前链表的下一个元素置为链表的最前端
            reverseHead.next = current; // 将头部元素和当前节点连接
            current = currentNext;
        }
        head.next = reverseHead.next; // 将反转节点的元素赋值给旧的头部元素
    }


    /**
     * 获取倒数第index个链表节点
     *
     * @param index
     * @return
     */
    public HeroNode getLastIndexNode(int index) {
        HeroNode temp = head;
        if (temp.next == null) {
            return null;
        }
        int length = length();
        if (index <= 0 || index > length) {
            return null;
        }
        temp = temp.next; // 注意忽略头节点
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 统计有效节点个数
     *
     * @return
     */
    public int length() {
        HeroNode temp = head;
        if (temp.next == null) {
            return 0;
        }
        int length = 0;
        while ((temp = temp.next) != null) {
            length++;
        }
        return length;
    }

    /**
     * 向链表尾部添加元素
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 1.需遍历到链表尾部，此时链表尾部元素的下一个元素为null值
        HeroNode temp = head;
        while (true) {
            // 当节点的下个元素为null值时，则证明遍历到了最后一个元素
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 2.将尾部元素的next节点指向新的heroNode
        temp.next = heroNode;
    }

    /**
     * 根据节点的no值进行顺序添加（升序）
     *
     * @param heroNode
     */
    public void addByNo(HeroNode heroNode) {
        // 1.找到添加的位置
        HeroNode temp = head;
        boolean isExist = false; // 判断这个序号是否已经添加过了，默认没有false
        while (true) {
            if (temp.next == null) { // 说明在链表的最后，直接添加
                break;
            }
            if (temp.next.no > heroNode.no) { // 如果指针节点的下个节点的no值大于新节点的no值，则表明可添加
                break;
            } else if (temp.next.no == heroNode.no) { // 如果相等，则该no值已经存在
                isExist = true;
                break;
            }
            temp = temp.next; // 如果以上条件都不满足，则继续遍历
        }
        if (isExist) {
            System.out.printf("准备插入的英雄编号 %d 已经存在", heroNode.no);
        } else { // 此时已找到插入的位置，将找到位置的temp的下个节点赋值给新节点的下个节点
            // 将temp的下个节点赋值为新节点
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 根据编号no来修改链表里的值
     *
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode) {
        HeroNode temp = head.next;
        boolean isFind = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                isFind = true;
                break;
            }
            temp = temp.next;
        }
        if (isFind) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("未找到编号为 %d 的英雄", newHeroNode.no);
        }
    }

    /**
     * 根据编号no删除相关节点
     *
     * @param no
     */
    public void remove(int no) {
        HeroNode temp = head;
        boolean isFind = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                isFind = true;
                break;
            }
            temp = temp.next;
        }
        if (isFind) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("编号为 %d 的节点未找到", no);
        }
    }

    /**
     * 遍历链表并打印链表中的数据
     */
    public void list() {
        // 此时无需打印头部元素
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}

/**
 * 英雄节点类
 */
class HeroNode {
    final int no; // 排名，不能修改
    String name;    // 姓名
    String nickname;    // 昵称

    HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}