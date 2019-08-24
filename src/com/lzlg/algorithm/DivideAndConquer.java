package com.lzlg.algorithm;

/**
 * 分治算法：
 * 将一个大问题，分解为几个独立的小问题，
 * 解决这些小问题后，通过合并得出大问题的结果。
 */
public class DivideAndConquer {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    /**
     * 分治算法经典案例：汉诺塔问题
     * 可将问题分解为：
     * 最后一个盘 和 其他的盘
     * 每个步骤都是把 最后一个盘挪到目标位置，将其他的盘放到辅助的位置上
     *
     * @param num   盘的数量
     * @param start 起始位置
     * @param aid   辅助位置
     * @param end   目标位置
     */
    private static void hanoiTower(int num, char start, char aid, char end) {
        if (num == 1) { // 只有一个数量的时候直接挪走
            System.out.println(start + "->" + end);
        } else {
            // 将num-1个盘从 start挪到辅助位置
            hanoiTower(num - 1, start, end, aid);
            // 把最后一个盘挪到结束位置
            System.out.println(start + "->" + end);
            // 将其他剩余的盘，从辅助位置挪到终点位置
            hanoiTower(num - 1, aid, start, end);
        }
    }
}
