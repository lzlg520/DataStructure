package com.lzlg.sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {9, 2, 1, 3, 5, 4, 8, 7, 0, 6};
        System.out.println("排序前的数组：");
        CommonUtil.print(array);



        System.out.println("排序后的数组：");
        CommonUtil.print(array);
    }
}
