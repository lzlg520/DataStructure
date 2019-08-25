package com.lzlg.interview.algorithm;

/**
 * 背包问题
 */
public class BackpackProblemDemo {
    public static void main(String[] args) {
        final int MAX_WEIGHT = 8;
        final int MIN_WEIGHT = 1;
        // 记录容量为下标时，装入背包的最后的水果下标
        int[] key = new int[MAX_WEIGHT + 1];

        // 记录容量为下标的背包能装入的最大价格的水果
        int[] value = new int[MAX_WEIGHT + 1];

        FruitInBag[] fruitInBags = {
                new FruitInBag("李子", 4, 4500),
                new FruitInBag("苹果", 5, 5700),
                new FruitInBag("橘子", 2, 2250),
                new FruitInBag("草莓", 1, 1100),
                new FruitInBag("甜瓜", 6, 6700)
        };

        for (int i = 0; i < fruitInBags.length; i++) {
            for (int j = fruitInBags[i].getWeight(); j <= MAX_WEIGHT; j++) {
                int p = j - fruitInBags[i].getWeight();
                int newValue = value[p] + fruitInBags[i].getPrice();
                if (newValue > value[j]) {
                    value[j] = newValue;
                    key[j] = i;
                }
            }
        }

        System.out.println("物品\t\t价格");
        for (int i = MAX_WEIGHT; i >= MIN_WEIGHT; i = i - fruitInBags[key[i]].getWeight()) {
            System.out.println(fruitInBags[key[i]].getName() + "\t\t" +
                    fruitInBags[key[i]].getPrice());
        }
    }
}

class FruitInBag {
    private String name;
    private int weight;
    private int price;

    public FruitInBag(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "FruitInBag{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}