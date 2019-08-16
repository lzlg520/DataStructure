package com.lzlg.sort;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] array = {9, 2, 1, 3, 5, 4, 8, 7, 0, 6};
//
//        System.out.println("排序前数组：");
//        CommonUtil.print(array);
//
//        sort(array, 0, array.length - 1);
//
//        System.out.println("排序后数组：");
//        CommonUtil.print(array);

        int[] array = CommonUtil.randomArray(8000000);
        System.out.println("使用快速排序80000个数据使用的时间为：" + CommonUtil.costTime(array, QuickSort::sort));

    }

    /**
     * 重载方法，便于测试
     *
     * @param array
     */
    private static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * 快速排序本质上是对冒泡排序的优化，规则如下：
     * 1.以最左，中间，最右的数组元素为基准
     * 2.将小于该元素的放在数组左边，大于该元素的放在数组右边，进行交换
     * 直到左边的元素全部小于基准元素，右边的元素全部大于基准元素
     * 3.开始递归，将全部小于基准元素的部分按照1，2步骤再次进行，
     * 同样的，将全部大于基准元素的部分也按照1，2步骤再次进行。
     */
    private static void sort(int[] array, int left, int right) {
        int l = left; // 记录左下标
        int r = right; // 记录右下标
        int middle = array[(left + right) / 2]; // 记录中间值
        int temp = 0; // 交换使用的临时值

        // 循环的目的，让大于middle的值放在右边，让小于middle的值放在左边
        while (l < r) {
            // 从左遍历，查找大于middle值的下标
            while (array[l] < middle) {
                l += 1;
            }
            // 从右遍历，查找小于middle值的下标
            while (array[r] > middle) {
                r -= 1;
            }
            // 如果前两个遍历没有查找到这些值，就直接退出循环
            if (l >= r) {
                break;
            }
            // 交换，将左边的大值 和 右边的小值
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            // 如果交换完后，发现这个array[l] == middle值 相等 r--， 前移
            if (array[l] == middle) {
                r -= 1;
            }
            // 如果交换完后，发现这个array[r] == middle值 相等 l++， 后移
            if (array[r] == middle) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r) {
            sort(array, left, r);
        }

        if (right > l) {
            sort(array, l, right);
        }
    }
}
