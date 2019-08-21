package com.lzlg.interview.algorithm;

import java.util.Random;

/**
 * 掷骰子游戏：
 * 玩家掷两个骰子（1~6）如果第一次点数为7或11 玩家胜
 * 如果点数为 2，3，12，玩家输
 * 如果是其他点数，则继续投掷，
 * 直到点数和等于第一次掷出的点数和，则玩家胜。
 * 如果在此期间掷出了点数7，则玩家输。
 */
public class DiceGameDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int first = 0;
        int count = 0;
        while (true) {
            count++;
            int one = random.nextInt(6) + 1;
            int two = random.nextInt(6) + 1;
            System.out.println("first : " + one + "; second : " + two);
            if (count == 1) {
                first = one + two;
                if (first == 7 || first == 11) {
                    System.out.println("玩家胜");
                    break;
                }
                if (first == 2 || first == 3 || first == 12) {
                    System.out.println("玩家输");
                    break;
                }
            } else {
                int point = one + two;
                if (point == 7) {
                    System.out.println("玩家输");
                    break;
                }

                if (point == first) {
                    System.out.println("玩家胜");
                    break;
                }
            }
        }
    }
}
