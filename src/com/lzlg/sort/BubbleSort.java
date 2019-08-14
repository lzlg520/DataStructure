package com.lzlg.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] array = {3, 8, -1, 6, 5, 4, 10, 2};
//        System.out.println("排序前的数组：");
//        CommonUtil.print(array);
//
//        sort(array);
//        System.out.println("排序后的数组：");
//        CommonUtil.print(array);

        int[] testArray = CommonUtil.randomArray(80000);
        System.out.println("80000个元素的数组冒泡排序所花费的时间为：" + CommonUtil.costTime(testArray, BubbleSort::sort));
    }

    /**
     * 排序方法
     * 循环第一次，把最大的排序在最后
     * 取出一个元素A和该元素后面的一个元素B进行比较
     * 如果 A > B 则 A 和 B 进行交换
     * <p>
     * 进行第二次排序时，就忽略掉最后的元素
     * 对前面的元素进行上诉过程
     * <p>
     * 然后依次类推
     * <p>
     * 优化：设置一个标记变量，如果进行过交换，就改变其值
     *
     * @param array
     */
    private static void sort(int[] array) {
        int temp;
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true; // 如果发生交换，就置为true
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (flag) { // 发生交换，继续进行，此时必须注意 flag置为false(原来的值)
                flag = false;
            } else { // 无发生交换，直接退出循环
                break;
            }
//            System.out.println("第" + (i + 1) + "次排序的数组：");
//            CommonUtil.print(array);
        }
    }

}
