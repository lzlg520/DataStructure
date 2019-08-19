package com.lzlg.interview.algorithm;

public class SingletonDemo {
    public static void main(String[] args) {

    }
}

/**
 * 使用静态变量存储单例
 */
class Singleton {
    private Singleton() {
    }

    /**
     * 饿汉式
     */
//    private static Singleton instance = new Singleton();
//
//    public static Singleton getInstance() {
//        return instance;
//    }

    /**
     * 懒汉式
     */
//    private static Singleton instance;
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /**
     * 双重校验锁
     */
//    private volatile static Singleton instance;
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    public static final Singleton getInstance() {
        return SingletonHolder.instance;
    }
}

/**
 * 使用枚举
 */
enum SingletonEnum {
    INSTANCE;
}