package com.lzlg.interview.clz;

public class ContructorTest {
}

class A {
    public A(String name) {
        Runnable r = () -> System.out.println();
        Thread thread = new Thread(r);
    }
}

class B extends A {
    public B() {
        super("555");
    }
}