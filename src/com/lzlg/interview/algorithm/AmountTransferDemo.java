package com.lzlg.interview.algorithm;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 将阿拉伯数字的金额转换成中国传统形式：
 * 1011 -> 壹仟零壹拾壹元整
 */
public class AmountTransferDemo {

    static String[] chineseNo = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    static String[] digit = {"分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿",
            "拾", "佰", "仟", "兆", "拾", "佰", "仟"};

    static String full = "整";

    static String negative = "负";

    static int precision = 2;

    static String zeroFull = "零元" + full;

    private static String transfer(BigDecimal money) {
        int signum = money.signum();
        if (signum == 0) {
            return zeroFull;
        }

        long number = money.movePointRight(precision).setScale(0, 4)
                .abs().longValue();
        // 得到小数点后两位
        long scale = number % 100;
        int numUnit = 0;    // 单位计数
        int numIndex = 0;   // 下标计数

        boolean getZero = false;

        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }

        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        StringBuilder sb = new StringBuilder();
        int zeroSize = 0;
        while (true) {
            if (number <= 0) {
                break;
            }
            numUnit = (int) number % 10;
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, digit[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, digit[10]);
                }
                sb.insert(0, digit[numIndex]);
                sb.insert(0, chineseNo[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                if (!getZero) {
                    sb.insert(0, chineseNo[numUnit]);
                }

                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, digit[numIndex]);
                    }
                } else if ((numIndex - 2) % 4 == 0 && (number % 1000 > 0)) {
                    sb.insert(0, digit[numIndex]);
                }
                getZero = true;
            }

            number = number / 10;
            ++numIndex;
        }

        if (signum == -1) {
            sb.insert(0, negative);
        }
        if (!(scale > 0)) {
            sb.append(full);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入金额：");
        double n = scanner.nextDouble();

        String chineseMoney = transfer(new BigDecimal(n));
        System.out.println("转换成中国传统形式为：" + chineseMoney);

    }
}
