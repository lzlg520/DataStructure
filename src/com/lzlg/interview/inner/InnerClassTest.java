package com.lzlg.interview.inner;

import javax.swing.*;

/**
 * 静态内部类不依赖于外部类的实例而被实例化
 * <p>
 * 通常的内部类需要在外部类实例化之后才能被实例化
 */
public class InnerClassTest {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.freeMemory());

//        System.exit(1);

        Math.random();

        Object o = new Object();
        System.out.println(o.hashCode());

    }
    private String a;

//    public int addOne(final int x) {
//        return ++x;
//    }
}

class NativeClass {
    public native void method();
}

class SubClass extends NativeClass {
}