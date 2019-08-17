package com.lzlg.sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] array = {9, 2, 1, 3, 5, 4, 8, 7, 0, 6};
//        System.out.println("排序前的数组：");
//        CommonUtil.print(array);
//
//        sort(array);
//
//        System.out.println("排序后的数组：");
//        CommonUtil.print(array);

        int[] array = CommonUtil.randomArray(80000000);
        System.out.println("归并排序所花费时间：" + CommonUtil.costTime(array, MergeSort::sort));
//        CommonUtil.print(array);
    }

    private static void sort(int[] array) {
        int[] temp = new int[array.length];
        split(array, 0, array.length - 1, temp);
    }

    /**
     * 归并排序拆分方法
     *
     * @param array
     * @param left
     * @param right
     * @param temp
     */
    private static void split(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左递归拆分
            split(array, left, mid, temp);
            // 向右递归拆分
            split(array, mid + 1, right, temp);

            // 拆分完成后，进行归并操作
            merge(array, left, mid, right, temp);
        }
    }

    /**
     * 归并排序归并方法
     * 将有序的两个子序列进行合并，
     * 遍历时进行比较，将较小的元素放入临时数组里，
     * 然后将较大的元素依照顺序放入临时数组中，
     * 然后将临时数组copy给原始数组
     *
     * @param array 原始数组
     * @param left  左边元素的起始位置
     * @param mid   右边元素的起始位置的上一个
     * @param right 右边元素的结束位置
     * @param temp  临时用来存储结果的数组
     */
    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int index = 0; // 临时数组的下标
        int l = left;
        int r = mid + 1;
        // 同时对两个子序列进行遍历
        while (l <= mid && r <= right) {
            // 如果左边元素比右边元素小，则把左边元素放入临时数组中
            if (array[l] <= array[r]) {
                temp[index] = array[l];
                index += 1;
                l += 1;
            } else { // 反之，将右边元素放入临时数组中
                temp[index] = array[r];
                index += 1;
                r += 1;
            }
        }

        // 遍历完成后，判断左边或右边的序列是否还有未加入临时数组的元素
        while (l <= mid) {
            temp[index] = array[l];
            l += 1;
            index += 1;
        }
        while (r <= right) {
            temp[index] = array[r];
            index += 1;
            r += 1;
        }

        // 将临时数组的元素copy到原始数组中
        index = 0;
        int copyLeft = left;
        while (copyLeft <= right) {
            array[copyLeft] = temp[index];
            index += 1;
            copyLeft += 1;
        }
    }
}
