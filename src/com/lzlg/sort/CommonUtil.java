package com.lzlg.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

/**
 * 通用方法工具类
 */
public class CommonUtil {
    private CommonUtil() {
    }

    /**
     * 生成count长度的随机数组
     *
     * @param count
     * @return
     */
    public static int[] randomArray(int count) {
        Random random = new Random();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = random.nextInt(800000);
        }
        return array;
    }

    /**
     * 打印数组信息
     *
     * @param array
     */
    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     * 测量排序方法的时间
     *
     * @param array
     * @param consumer
     * @return
     */
    public static long costTime(int[] array, Consumer<int[]> consumer) {
        long start = System.currentTimeMillis();
        consumer.accept(array);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
