package com.lzlg.sort;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
//        int[] array = {53, 4, 542, 748, 14, 214};
//        System.out.println("排序前数组：");
//        CommonUtil.print(array);
//
//        sort(array);
//
//        System.out.println("排序后数组：");
//        CommonUtil.print(array);

        int[] array = CommonUtil.randomArray(8000000);
        System.out.println("基数排序时间为：" + CommonUtil.costTime(array, RadixSort::sort));

//        CommonUtil.print(array);
    }

    /**
     * 获取数组中最大元素的位数
     *
     * @param array
     * @return
     */
    private static int getMaxNumberLength(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return (max + "").length();
    }

    /**
     * 基数排序：
     * 1.创建10个桶，每个桶(数组)的长度为元素数组的长度
     * 同时使用一维数组记录每个桶里元素的数量
     * 2.第一次循环，将数组中的元素按照 个位 进行分桶，
     * 将个位数为相应桶的位置下标 的元素放入相应的桶中，
     * 完成后，将桶中的元素按照次序依次取出到原始数组中。
     * 3.同样第二次，将数组的元素按照 十位 进行分桶，
     * 按照2 的方法进行
     * 依次类推直到 最高位的元素 也按照此法完成。
     *
     * @param array
     */
    private static void sort(int[] array) {
        // 创建桶，最极端的情况：数组里的元素的个位全都一样，这样桶的长度必须为原始数组的长度
        int[][] bucket = new int[10][array.length];
        // 创建一维数组，记录桶里元素的数量
        int[] bucketElementCount = new int[10];
        // 最大数字的位数
        int length = getMaxNumberLength(array);

        for (int k = 0, n = 1; k < length; k++, n *= 10) {
            // 第一次，从个位开始装桶
            for (int i = 0; i < array.length; i++) {
                int digit = array[i] / n % 10;// 取出元素的个位
                // 桶位置的下标为 个位数对应的数字
                // 记录桶元素数量的数组 的下标 对应桶位置的下标
                bucket[digit][bucketElementCount[digit]] = array[i];
                // 对应的桶元素的数量加1
                bucketElementCount[digit]++;
            }
            // 将桶中的元素取出
            int index = 0;
            for (int i = 0; i < 10; i++) {
                // 判断桶中的元素数量是否为0
                if (bucketElementCount[i] != 0) {
                    for (int j = 0; j < bucketElementCount[i]; j++) {
                        array[index++] = bucket[i][j];
                    }
                    // 取出元素后将相关桶中的数量清零
                    bucketElementCount[i] = 0;
                }
            }
        }

        /*
        // 第一次，从个位开始装桶
        for (int i = 0; i < array.length; i++) {
            int digit = array[i] / 1 % 10;// 取出元素的个位
            // 桶位置的下标为 个位数对应的数字
            // 记录桶元素数量的数组 的下标 对应桶位置的下标
            bucket[digit][bucketElementCount[digit]] = array[i];
            // 对应的桶元素的数量加1
            bucketElementCount[digit]++;
        }
        // 将桶中的元素取出
        int index = 0;
        for (int i = 0; i < 10; i++) {
            // 判断桶中的元素数量是否为0
            if (bucketElementCount[i] != 0) {
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    array[index++] = bucket[i][j];
                }
                // 取出元素后将相关桶中的数量清零
                bucketElementCount[i] = 0;
            }
        }


        // 第二次，从十位开始装桶
        for (int i = 0; i < array.length; i++) {
            int digit = array[i] / 10 % 10;// 取出元素的十位
            // 桶位置的下标为 十位数对应的数字
            // 记录桶元素数量的数组 的下标 对应桶位置的下标
            bucket[digit][bucketElementCount[digit]] = array[i];
            // 对应的桶元素的数量加1
            bucketElementCount[digit]++;
        }
        // 将桶中的元素取出
        index = 0;
        for (int i = 0; i < 10; i++) {
            // 判断桶中的元素数量是否为0
            if (bucketElementCount[i] != 0) {
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    array[index++] = bucket[i][j];
                }
                // 取出元素后将相关桶中的数量清零
                bucketElementCount[i] = 0;
            }
        }


        // 第三次，从百位开始装桶
        for (int i = 0; i < array.length; i++) {
            int digit = array[i] / 100 % 10;// 取出元素的百位
            // 桶位置的下标为 百位数对应的数字
            // 记录桶元素数量的数组 的下标 对应桶位置的下标
            bucket[digit][bucketElementCount[digit]] = array[i];
            // 对应的桶元素的数量加1
            bucketElementCount[digit]++;
        }
        // 将桶中的元素取出
        index = 0;
        for (int i = 0; i < 10; i++) {
            // 判断桶中的元素数量是否为0
            if (bucketElementCount[i] != 0) {
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    array[index++] = bucket[i][j];
                }
                // 取出元素后将相关桶中的数量清零
                bucketElementCount[i] = 0;
            }
        } */
    }
}
