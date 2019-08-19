package com.lzlg.interview.algorithm;

import java.util.Scanner;

/**
 * 将阿拉伯数字的金额转换成中国传统形式：
 * 1011 -> 壹仟零壹拾壹元整
 */
public class AmountTransferDemo {

    static String[] chineseNo = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    static String[] digit = {"分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿",
            "拾", "佰", "仟", "兆", "拾", "佰", "仟"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入金额：");
        int n = scanner.nextInt();

        String chineseMoney = transfer(n);
        System.out.println("转换成中国传统形式为：" + chineseMoney);

    }

    private static String transfer(int n) {
        if (n >= 0) {
            String[] array = ("" + n).split(""); // 获取位数
            int len = array.length;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(chineseNo[Integer.parseInt(array[i])]);
                sb.append(digit[len - i - 1]);
            }

            return sb.toString();

        } else {
            throw new RuntimeException("Not right Number.");
        }
    }
}
