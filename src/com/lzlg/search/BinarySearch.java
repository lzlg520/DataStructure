package com.lzlg.search;

/**
 * 二分查找，需要有序
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 6, 9, 20, 33};
        int index = search(array, 0);
        System.out.println("index = " + index);

    }

    private static int search(int[] array, int findValue) {
        return search(array, 0, array.length - 1, findValue);
    }

    /**
     * 二分查找
     * 将有序数组(从小到大)从中间分开，
     * 要查找的值 大于中间的数，则向右查找
     * 要查找的值 小于中间的数，则向左查找
     * 一直递归直到找到，
     * 如果left值大于right值说明，查找不到该值，直接返回-1
     *
     * @param array     原始数组
     * @param left      左边起始下标
     * @param right     右边结束下标
     * @param findValue 要查找的值
     * @return 返回数组下标，查找不到返回-1
     */
    private static int search(int[] array, int left, int right, int findValue) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int middleValue = array[mid];

        if (findValue > middleValue) {
            return search(array, mid + 1, right, findValue);
        } else if (findValue < middleValue) {
            return search(array, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }
}
