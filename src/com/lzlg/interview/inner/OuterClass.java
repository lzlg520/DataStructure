package com.lzlg.interview.inner;

public class OuterClass {
    private double d = 1.0;

    /**
     * 1.非静态内部类不能有任何的 static 变量和方法
     */
//    class InnerOne {
//        private static double d = 2.0;
//        static double method() {
//            return d;
//        }
//    }

    /**
     * 2.内部类可声明为public
     */
//    public class InnerOne {
//
//    }

//    private class InnerOne {
//        double method() {
//            return d;
//        }
//    }

    /**
     * 3.静态内部内只能访问外部类的静态成员
     */
    static class InnerOne {
        private static double a = 2.0;

        protected double method() {
            return a;
        }
    }
    /**
     * 内部类规则：
     * 1.内部类可以被定义在方法中，可以访问外部类的final变量
     * 2.内部类可以被定义为abstract抽象类
     * 3.内部类可以被声明为private或protected
     * 4.内部类可以作为一个接口，由另一个内部类实现
     * 4.非静态内部类不能声明任何static成员
     */
}
