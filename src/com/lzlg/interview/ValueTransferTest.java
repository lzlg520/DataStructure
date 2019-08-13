package com.lzlg.interview;

/**
 * Java值传递
 */
public class ValueTransferTest {
    public static void main(String[] args) {
        int x = 1;
        ValueTransferTest test = new ValueTransferTest();
        System.out.print("x1=" + x);

        test.setValue(x);

        System.out.print(" x3=" + x);

        System.out.println("\n华丽的分割线=====>>>>>>>>>>>");

        int num;
        double d;
        char c;
        num = 10;
        d = 1258.35698;
        c = 'a';
        System.out.println("int is " + num);
        System.out.println("double is " + d);
        System.out.println("char is " + c);
        System.out.println();

        System.out.println("calling setValue");
        setValue(num, d, c);

        System.out.println("\nreturned from setValue");
        System.out.println("num is " + num);
        System.out.println("d is " + d);
        System.out.println("c is " + c);

        System.out.println("\n华丽的分割线=====>>>>>>>>>>>");

        TestDemo testDemo = new TestDemo();
        testDemo.show();

    }

    private static void setValue(int num, double d, char c) {
        System.out.println("in setValue...");

        num = 0;
        d = 123.568;
        c = 'b';
        System.out.println("num is " + num);
        System.out.println("d is " + d);
        System.out.println("c is " + c);
    }

    private void setValue(int x) {
        x = x + 1;
        System.out.print(" x2=" + x);
    }
}
class TestDemo {
    public void tryTest(Test test) {
        double t = test.getS();
        test.setS(t * 2);
    }

    public void show() {
        Test test = new Test();
        test.setS(100.51);
        System.out.println("调用 tryTest 方法之前，s = " + test.getS());

        tryTest(test);
        System.out.println("调用 tryTest 方法之后，s = " + test.getS());
    }
}

class Test {
    private double s;

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }
}