package com.lzlg.sort;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] array = {3, 8, -1, 6, 5, 4, 10, 2};
//        System.out.println("排序前的数组：");
//        CommonUtil.print(array);
//
//        sort(array);
//
//        System.out.println("排序后的数组：");
//        CommonUtil.print(array);


        int[] testArray = CommonUtil.randomArray(80000);
        System.out.println("80000个元素的数组选择排序所花费的时间为：" + CommonUtil.costTime(testArray, SelectSort::sort));

    }

    /**
     * 选择排序：
     * 第一次循环，选出最小值，将最小值放置在第一个位置 array[0]
     * 第二次循环，选出除了第一个位置的其他元素的最小值，将该值放入第二个位置 array[1]
     * 依次类推
     *
     * @param array
     */
    private static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int pos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) { // 选出最小的值
                    min = array[j];
                    pos = j; // 并将最小值的下标信息记录
                }
            }
            if (i != pos) { // 如果下标信息不是原来的，则进行交换
                array[pos] = array[i];
                array[i] = min;
//                System.out.println("第" + (i + 1) + "次循环排序后的数组为：");
//                CommonUtil.print(array);
            }
        }
    }
}
