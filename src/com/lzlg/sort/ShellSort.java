package com.lzlg.sort;

/**
 * 希尔排序，本质上是对插入/冒泡排序的优化
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] array = {9, 2, 1, 3, 5, 4, 8, 7, 0, 6};
//        System.out.println("排序前的数组：");
//        CommonUtil.print(array);
//
//        sort(array);
//
//        System.out.println("排序后的数组：");
//        CommonUtil.print(array);


        int[] array = CommonUtil.randomArray(80000);
//        System.out.println("使用希尔排序优化冒泡排序后，80000数据排序使用时间：" + CommonUtil.costTime(array, ShellSort::sort));

        System.out.println("使用希尔排序优化插入排序后，80000数据排序使用时间：" + CommonUtil.costTime(array, ShellSort::sort));

    }

    /**
     * 先将整个数组的长度除以2，得到长度A
     * 划分成几个小组，对这几个小组进行插入/冒泡排序
     * <p>
     * 然后再将长度A除以2，
     * 还是划分成几个小组，对这几个小组进行插入/冒泡排序
     * <p>
     * 然后以此类推
     *
     * @param array
     */
    private static void sort(int[] array) {
        // 交换法希尔排序，基于冒泡排序进行优化
//        int temp;
//        for (int grap = array.length / 2; grap > 0; grap /= 2) {
//            for (int i = grap; i < array.length; i++) {
//                for (int j = i - grap; j >= 0; j -= grap) {
//                    if (array[j] > array[j + grap]) {
//                        temp = array[j];
//                        array[j] = array[j + grap];
//                        array[j + grap] = temp;
//                    }
//                }
//            }
//        }

        // 移动法希尔排序，基于插入排序优化
        for (int grap = array.length / 2; grap > 0; grap /= 2) {
            for (int i = grap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                if (array[j] < array[j - grap]) {
                    while (j - grap >= 0 && temp < array[j - grap]) {
                        array[j] = array[j - grap];
                        j -= grap;
                    }
                    array[j] = temp;
                }
            }
        }
    }
}
