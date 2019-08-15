package com.lzlg.interview.collection;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add(1, "3");
        List<String> listTwo = new LinkedList<>(list);
        list.addAll(listTwo);

        listTwo = list.subList(2, 5);
        listTwo.clear();
        System.out.println(list);
    }

    /**
     * heap(堆) 和 stack(栈) 有什么区别?
     * 1.栈是一种线性集合，是自动分配变量以及函数调用时所使用的一些空间。
     *   地址是由高向低减少的。其添加和删除元素的操作应同步完成。
     *   栈按照后进先出的方式进行处理。
     * 2.堆是栈的一个组成元素，它是由malloc之类的函数分配空间所在地，
     *   地址是由低向高增长的。
     */

    /**
     * ArrayList，Vector都是用数组方式存储数据，
     * 数组元素数量大于实际存储的数据以便增加和插入元素，
     * 都允许直接按序号查找元素，但插入和删除元素涉及数组元素移动等操作，
     * 所以索引数据快，插入数据慢。
     * Vector是线程安全的，性能较ArrayList差
     *
     * LinkedList使用双向链表进行存储，按照序号索引数据需要向前或向后遍历，
     * 但是插入数据时只需要记录本项的前后项即可，插入数据较快。
     */
}
