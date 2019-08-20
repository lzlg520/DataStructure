package com.lzlg.sort;

/**
 * 堆排序
 * 1.概念：
 * 大顶堆 ：每个节点的值都大于等于左右节点的值
 * 小顶堆 ：每个节点的值都小于等于左右节点的值
 * 2.如果是升序排序使用大顶堆，降序排序使用小顶堆
 * 3.排序思想：
 * 将数组（已转换成顺序存储二叉树）转换成大顶堆或小顶堆 === 最关键的步骤
 * 然后将堆顶的元素放入数组的开头或结尾，
 * 然后将剩余的元素（除去开头和结尾）通过上述方法再次进行
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] array = {4, 6, 8, 5, 9, 1};
//        System.out.println("数组排序前：");
//        CommonUtil.print(array);
//
//        sort(array);
//
//        System.out.println("数组排序后：");
//        CommonUtil.print(array);

        int[] array = CommonUtil.randomArray(8000000);
        System.out.println("堆排序时间：" + CommonUtil.costTime(array, HeapSort::sort));
    }

    private static void sort(int[] array) {
        // 将整个数组形成大顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            toBigTopHeap(array, i, array.length);
        }

        int temp = 0; // 用于将大顶堆上的值和第一个数组元素交换
        for (int i = array.length - 1; i > 0; i--) {
            temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 再次调整堆结构（除去最后一个已经最大的元素）
            toBigTopHeap(array, 0, i);
        }

        // 将整个数组形成小顶堆
//        for (int i = array.length / 2 - 1; i >= 0; i--) {
//            toSmallTopHeap(array, i, array.length);
//        }
//
//        int temp = 0; // 用于将小顶堆上的值和最后一个数组元素交换
//        for (int i = array.length - 1; i > 0; i--) {
//            temp = array[i];
//            array[i] = array[0];
//            array[0] = temp;
//            // 再次调整堆结构（除去最后一个已经最大的元素）
//            toSmallTopHeap(array, 0, i);
//        }
    }

    /**
     * 将局部的子树变成大顶堆
     *
     * @param array  数组
     * @param i      当前局部子树的顶部节点
     * @param length 成堆的元素个数
     */
    private static void toBigTopHeap(int[] array, int i, int length) {
        int temp = array[i]; // 存储当前顶点的值
        // 当前顶点的左节点进行遍历
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            // 比较左节点和右节点的大小
            if (j + 1 < length && array[j] < array[j + 1]) {
                j++; // 将j指向右节点
            }

            if (array[j] > temp) { // 和当前的订单比较
                array[i] = array[j]; // 将最大值放在顶点上
                i = j; // 记录最大值的位置，到时候交换 对应 array[i] = temp
            } else { // 没有找到比当前顶点大的值，则退出循环
                // 因为是从下到上，从左到右进行比较，所以可以直接break
                break;
            }
        }

        array[i] = temp; // 将原来最大值位置的值变为以前的顶点的值
    }

    /**
     * 将局部的子树变成小顶堆
     *
     * @param array  数组
     * @param i      当前局部子树的顶部节点
     * @param length 成堆的元素个数
     */
    private static void toSmallTopHeap(int[] array, int i, int length) {
        int temp = array[i]; // 存储当前顶点的值
        // 当前顶点的左节点进行遍历
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            // 比较左节点和右节点的大小
            if (j + 1 < length && array[j] > array[j + 1]) {
                j++; // 将j指向右节点
            }

            if (array[j] < temp) { // 和当前的订单比较
                array[i] = array[j]; // 将最小值放在顶点上
                i = j; // 记录最小值的位置，到时候交换 对应 array[i] = temp
            } else { // 没有找到比当前顶点小的值，则退出循环
                // 因为是从下到上，从左到右进行比较，所以可以直接break
                break;
            }
        }

        array[i] = temp; // 将原来最小值位置的值变为以前的顶点的值
    }

}
