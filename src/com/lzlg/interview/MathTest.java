package com.lzlg.interview;

import java.util.*;

public class MathTest {
    public static void main(String[] args) {
//        double d = -11.5;
//        System.out.println(Math.abs(d));
//        System.out.println(Math.ceil(d));

//        double d = 11.5;
//        System.out.println(Math.floor(d));
//        System.out.println(Math.ceil(d));
//        System.out.println((int) Math.ceil(d));
//        System.out.println(Math.round(d));
//        System.out.println((int) Math.floor(d));

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        System.out.println(list.indexOf("666"));

        Set<Object> set = new HashSet<>();
        set.add(new Object());
        set.add(new Object());
        System.out.println(set.size());
    }
}
