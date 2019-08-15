package com.lzlg.sort;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] array = {9, 2, 1, 3, 5, 4, 8, 7, 0, 6};
//        System.out.println("数组排序前：");
//        CommonUtil.print(array);
//
//        sort(array);
//
//        System.out.println("数组排序后：");
//        CommonUtil.print(array);

        int[] array = CommonUtil.randomArray(80000);
        System.out.println("使用插入排序测试80000数据所用的时间为：" + CommonUtil.costTime(array, InsertSort::sort));
    }

    /**
     * 插入排序规则：从小到大
     * 把第一个元素当作有序的，
     * 然后拿出第二个元素和有序的进行比较，
     * 如果小于则把有序的数向后移动，把小值插入到前面
     * <p>
     * 以此类推
     *
     * @param array
     */
    private static void sort(int[] array) {
        int insertValue;
        int pos;
        for (int i = 1; i < array.length; i++) {
            insertValue = array[i];
            pos = i - 1;
            while (pos >= 0 && insertValue < array[pos]) {
                array[pos + 1] = array[pos];
                pos--;
            }
            if (pos + 1 != i) {
                array[pos + 1] = insertValue;
            }
        }
    }
}
