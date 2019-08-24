package com.lzlg.algorithm.dynamicplanning;

/**
 * 动态规划算法之背包问题
 * 有一个背包，容量为4磅
 * 有如下物品：
 * 名称     重量   价格
 * 吉他(G)  1磅   1500元
 * 音响(S)  4磅   3000元
 * 电脑(L)  3磅   2000元
 * 要求：
 * 1.使装入的背包的总价格为最大，且重量不超出
 * 2.要求装入的物品不能重复
 */
public class BackpackProblem {
    /**
     * 容量从1到4
     * 物品从G->S->L
     * 形成如下表格
     * <p>
     * 物品       1磅       2磅        3磅       4磅
     * 吉他(G)   1500(G)   1500(G)   1500(G)   1500(G)
     * 音响(S)   1500(G)   1500(G)   1500(G)   3000(S)
     * 电脑(L)   1500(G)   1500(G)   2000(l)   1500(G)+2000(l)
     * <p>
     * 当我们依次将物品加入背包时需考虑两种情况
     * 1.当前背包的空间（会从1~4磅变化）不足以添加新物品，则保持原来的方案不变
     * 2.当前背包的空间足以添加新物品，则需在原来的方案，
     * 添加新物品和剩余的空间能满足的最优配置的方案，这两个方案之间选择一个价格最大化的方案
     *
     * @param args
     */
    public static void main(String[] args) {
        Goods[] goods = {
                new Goods(1, 1500, "吉他"),
                new Goods(4, 3000, "音响"),
                new Goods(3, 2000, "电脑")
        };

        int capacity = 4; // 背包容量：4磅
        int goodsCount = goods.length; // 物品的个数

        // 用来保存最佳解决方案的二维数组
        // 其中列代表背包容量
        // 其中行代表物品
        int[][] optimalValues = new int[goodsCount + 1][capacity + 1];

        // 记录最优解放入的物品信息，如果放入了该商品则值为1
        // 同样 其中列代表背包容量  其中行代表物品
        int[][] path = new int[goodsCount + 1][capacity + 1];
        // 初始化数据

        // 把第一列的数据置为0
        for (int i = 0; i < goodsCount + 1; i++) {
            optimalValues[i][0] = 0;
        }
        // 把第一行的数据置为0
        for (int i = 0; i < capacity + 1; i++) {
            optimalValues[0][i] = 0;
        }

        // 动态规划解决背包问题
        for (int i = 1; i < goodsCount + 1; i++) {// 从下标1开始，i代表物品
            for (int j = 1; j < capacity + 1; j++) {// 从下标1开始，j代表当前背包的容量
                Goods g = goods[i - 1];
                if (g.getWeight() > j) {// 如果当前物品的容量大于背包的容量，则保持原来的方案
                    optimalValues[i][j] = optimalValues[i - 1][j];
                } else {// 如果当前物品的容量不大于背包的容量，
                    // 则比较原来的方案A和 当前物品的价格+除去该新物品后其他剩余空间的最优价格方案
                    int oldValue = optimalValues[i - 1][j];
                    int newValue = g.getValue() + optimalValues[i - 1][j - g.getWeight()];
                    optimalValues[i][j] = oldValue > newValue ? oldValue : newValue;
                    if (optimalValues[i][j] == newValue) {
                        path[i][j] = 1;
                    }
                }
            }
        }

        // 打印数据显示结果
        for (int i = 0; i < goodsCount + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                System.out.print(optimalValues[i][j] + " ");
            }
            System.out.println();
        }

        // 打印最优解
        int g = goodsCount;
        int c = capacity;
        while (c > 0 && g > 0) {
            if (path[g][c] == 1) {
                System.out.printf("第%d商品放入背包 : %s\n", g, goods[g - 1].toString());
                // 将容量减去 放入的g商品的重量，得到上一次放入的商品的信息
                c = c - goods[g - 1].getWeight();
            }
            g--;
        }
    }
}

class Goods {
    /**
     * 重量：单位磅
     */
    private int weight;
    /**
     * 价格：单位元
     */
    private int value;
    /**
     * 商品名称
     */
    private String name;

    public Goods(int weight, int value, String name) {
        this.weight = weight;
        this.value = value;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "weight=" + weight +
                ", value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}