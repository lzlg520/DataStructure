package com.lzlg;

import java.util.Stack;

public class AllTest {
    private static int x;

    public static void main(String[] args) {
        name(x);
        System.out.println(x);

        int 一つの = 0;

        System.out.println(一つの);

        Object object = new Object();

        int 一 = 2;
        System.out.println(一);
        int ￥money = 10;
        System.out.println(￥money);

        String 我叫张三 = "我都尽快发货就好！！！";

        String 哈哈 = "";

        System.out.println(我叫张三);

        double a = 2.12;
        int b = 0;

        double c = a / b;

        System.out.println("The Number is " + c);

        String j = "abc";
        String z = "c";
        String k = "ab" + z;

        System.out.println(j == k);
        System.out.println(j.equals(k));

        System.out.println(toBinary(5));
        // 异或^ 非~ 或| 与 &
        int xxx = ~6;

        System.out.println(xxx);

        System.out.println(runOp());

        System.out.println(Integer.toBinaryString(10));

        // 八进制整数前面有0，十六进制前面有0x或0X
        int ba = 0123;
        System.out.println(0123);
    }

//    private static void name(int x) {
//        x++;
//    }

    private static void name(int y) {
        x++;
    }

    /**
     * 把整数转换为二进制的字符串
     *
     * @param n
     * @return
     */
    private static String toBinary(int n) {
        Stack<String> stack = new Stack<>();
        while (n != 0) {
            stack.push(n % 2 + "");
            n = n / 2;
        }
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static int runOp() {
        int x = 1;
        int y = 1;
        System.out.println(x++ + y++ - y-- > 0);

        return x;
    }
}
