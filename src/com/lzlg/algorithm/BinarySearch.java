package com.lzlg.algorithm;

/**
 * 二分查找算法非递归
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 3, 8, 10, 11, 67, 100};
        int value = 100;
        int index = binarySearch(array, value);

        System.out.println("index = " + index);
    }

    /**
     * 二分查找，非递归
     *
     * @param array     查找的有序的数据数组（从小到大）
     * @param findValue 要查找的值
     * @return 查找到返回对应的下标，查找不到返回-1
     */
    private static int binarySearch(int[] array, int findValue) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > findValue) {// 要查找的值小于中间值，则在数组左边查找
                right = mid - 1; // 将right置为数组的左边最后一位的下标
            } else if (array[mid] < findValue) {// 要查找的值大于中间值，则在数组右边查找
                left = mid + 1; // 将left置为数组的右边第一位的下标
            } else {
                return mid;
            }
        }
        // 找不到返回-1
        return -1;
    }
}
