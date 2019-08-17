package com.lzlg.search;

/**
 * 查找查找，要求有序，是对二分法的改进
 * 基本规则同二分查找，对中间值进行了优化
 */
public class InsertSearch {
    public static void main(String[] args) {

        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }

        int index = search(array, 1);
        System.out.println("index = " + index);

    }

    private static int search(int[] array, int findValue) {
        return search(array, 0, array.length - 1, findValue);
    }

    private static int search(int[] array, int left, int right, int findValue) {
        if (left > right || findValue < array[0] || findValue > array[array.length - 1]) {
            return -1;
        }
        // 自适应mid值
        int mid = left + (right - left) * (findValue - array[left])
                / (array[right] - array[left]);

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
