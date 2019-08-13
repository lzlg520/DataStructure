package com.lzlg.interview;

public class DataTypeTest {

    /**
     * //没有继承的情形（且该类的类变量未被初始化）
     * 1.static变量初始化和static代码块
     * 2.实例变量初始化和实例变量初始化代码块
     * 3.构造函数
     * <p>
     * <p>
     * //有继承的情形（且该类和父类的类变量未被初始化）
     * 1.父类的static变量初始化和static代码块
     * 2.子类的static变量初始化和static代码块
     * 3.父类的实例变量初始化和实例变量初始化代码块
     * 4.父类的构造函数
     * 5.子类的实例变量初始化和实例变量初始化代码块
     * 6.子类构造函数
     */

    private int age;

//    public static void main(String[] args) {
//        DataTypeTest typeTest = new DataTypeTest();
//        System.out.println(typeTest.age);
//    }

    private static void testTypeTransfer() {
        short s = 1;
        s += 1; // 此时 s 变为 int 类型，编译器自动进行隐式类型转换
//        s = s + 1; s + 1 为 int 类型，此时 s 仍为 short 类型
        System.out.println(s);

        float f = 25.834F;
        float t = 2.5834E1F;
        System.out.println(f == t);

        float x = 58635.1235F;
        double d = 15210.2300356985412023689;

        // java规定float类型十进制数有效位为7位，整数位+小数位 = 7 多余的四舍五入 + 1(四舍五入的进位)
        // java规定double类型十进制数有效位为16位，整数位+小数位 = 16 多余的四舍五入 + 1(四舍五入的进位)
        System.out.println("单精度变量：" + x);
        System.out.println("双精度变量：" + d);
    }

    private static void charTest() {
        char c1 = '\u0008';
        char c2 = '\u0394';
        char c3 = '\uffff';
        char c4 = 'n';
        char c5 = 'a';
        char c6 = 'm';
        char c7 = 'e';
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("c4 ~ c7连起来是： " + c4 + c5 + c6 + c7);
        System.out.println("转义字符的使用：\n" + "ab\\dc\"fd\n你好");
    }

    private static void conversionTest() {
        double a = 123.5689124565656757657;
        float f = 2.65f;
        int n = 56;
        long l = 1234567894564654654L;
        System.out.println("int -> byte " + (byte) n);
        System.out.println("float -> int " + (int) f);
        System.out.println("double -> int " + (int) a);
        System.out.println("int -> char " + (char) n);
        // long 转为 float, double 精度丢失
        System.out.println("long -> float " + (float) l);
        System.out.println("long -> double " + (double) l);

        byte x = (byte) 1000L;
        System.out.println(x);
    }

    private static int testValue(int age) {
        return age;
    }

    // long 可以转换为 float 或 double 类型

    public static void main(String[] args) {
        testTypeTransfer();
        System.out.println(Math.PI);

        charTest();

        conversionTest();

        char a = 'a';
        System.out.println(testValue(a));
    }
}