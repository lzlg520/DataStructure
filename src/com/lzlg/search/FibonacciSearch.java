package com.lzlg.search;

import java.util.Arrays;

/**
 * 斐波那契(黄金分割)查找算法
 * 要求数据必须有序
 */
public class FibonacciSearch {

    public static void main(String[] args) {
        int[] array = {1, 2, 6, 7, 9, 10};

        int index = search(array, 888);

        System.out.println("index = " + index);
    }

    private static int maxSize = 20;

    /**
     * 产生20个元素的斐波那契数组
     *
     * @return
     */
    private static int[] fibonacciArray() {
        int[] array = new int[maxSize];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }

    /**
     * 斐波那契查找法：
     * 1.将数组元素个数补充为大于或等于斐波那契数
     * 2.遍历新的数组，中间值的下标为黄金分割数 - 1
     * 3.如果要查找的值大于该中间值，从该中间值的右边查找，
     * 在右边使用黄金分割点作为新的中间值，再次进行查找
     *
     * @param array
     * @param findValue
     * @return
     */
    private static int search(int[] array, int findValue) {
        // 找到大于等于数组元素的斐波那契数
        int high = array.length - 1;
        int[] fibonacciArray = fibonacciArray();
        int k = 0;
        while (high > fibonacciArray[k] - 1) {
            k++;
        }
        System.out.println(fibonacciArray[k]);

        // 将数组中的元素补充到斐波那契数
        int[] temp = Arrays.copyOf(array, fibonacciArray[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = array[high];
        }
        System.out.println(Arrays.toString(temp));

        // 对数组进行二分查找操作
        int low = 0;
        while (low <= high) {
            int mid = low + fibonacciArray[k - 1] - 1;
            if (findValue > temp[mid]) {// 如果大于向右查找
                low = mid + 1;

                // 由于 fibonacciArray[k - 1] = fibonacciArray[k - 1 - 1](左)
                //                              + fibonacciArray[k - 1 - 2](右)
                // 所以向右查找 是k-2
                k -= 2;
            } else if (findValue < temp[mid]) {
                // 在数组左边查找，所有从 0，到mid - 1
                high = mid - 1;
                k -= 1;
            } else {
                // 需要确定返回的是哪个下标，因为对数组的元素进行扩展了
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
