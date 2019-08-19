package com.lzlg.interview.algorithm;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * 有个长阶梯：
 * 每步上2阶，最后剩1步
 * 每步上3阶，最后剩2步
 * 每步上5阶，最后剩4步
 * 每步上6阶，最后剩5步
 * 每步上7阶，最后一阶都不剩
 * 求该阶梯至少有多少阶？
 */
public class MathQuestionDemo {
    public static void main(String[] args) {
        // 创建无限流，找到最小值
        OptionalInt any =
                IntStream.iterate(0, i -> i + 1).filter(i -> isRight(i)).limit(1).findAny();

        System.out.println(any.getAsInt());
    }

    private static boolean isRight(int i) {
        return ((i % 2 == 1) && (i % 3 == 2) && (i % 5 == 4) && (i % 6 == 5) && (i % 7 == 0));
    }
}
