package com.lzlg.interview.algorithm;

/**
 * 求两个正整数的最大公约数
 * 参考辗转相除法百度百科
 * gcd(a,b) = gcd(b,a mod b) (不妨设a>b 且r=a mod b ,r不为0)
 */
public class CommonDivisorDemo {
    public static void main(String[] args) {
        int a = 5;
        int b = 8;
        System.out.println(getCommonDivisor(a, b));
    }

    private static int getCommonDivisor(int one, int two) {
        return two == 0 ? one : getCommonDivisor(two, one % two);
    }
}
