package com.lzlg.search;

/**
 * 线性查找，无需有序
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {9, 2, 1, 3, 5, 4, 8, 7, 6};
        int index = search(array, 2);
        System.out.println("index = " + index);
    }

    private static int search(int[] array, int findValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findValue) {
                return i;
            }
        }
        return -1;
    }
}
