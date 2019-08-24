package com.lzlg.algorithm;

import java.util.*;

/**
 * 贪心算法：
 * 对问题求解时，每一步都采取最优的策略，从而希望能够导致结果为最优的算法
 * 注意：贪心算法得到的不一定是最优的结果，但是是相对接近最优解的算法
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        /////准备数据////
        // 1.所有未覆盖区域集合
        List<Area> allAreas = new ArrayList<>();
        allAreas.add(Area.BJ);
        allAreas.add(Area.SH);
        allAreas.add(Area.TJ);
        allAreas.add(Area.GZ);
        allAreas.add(Area.SZ);
        allAreas.add(Area.CD);
        allAreas.add(Area.HZ);
        allAreas.add(Area.DL);
        // 2.所有电台对象
        Radio k1 = new Radio("K1", Arrays.asList(Area.BJ, Area.SH, Area.TJ));
        Radio k2 = new Radio("K2", Arrays.asList(Area.GZ, Area.BJ, Area.SZ));
        Radio k3 = new Radio("K3", Arrays.asList(Area.CD, Area.SH, Area.HZ));
        Radio k4 = new Radio("K4", Arrays.asList(Area.SH, Area.TJ));
        Radio k5 = new Radio("K5", Arrays.asList(Area.HZ, Area.DL));

        // 3.电台对象Map，便于查找
        Map<String, Radio> radioMap = new HashMap<>();
        radioMap.put(k1.name, k1);
        radioMap.put(k2.name, k2);
        radioMap.put(k3.name, k3);
        radioMap.put(k4.name, k4);
        radioMap.put(k5.name, k5);

        // 4.结果集合
        List<Radio> radioList = new ArrayList<>();

        // 5.临时区域集合，用来存放电台覆盖区域和所有未覆盖区域的并集/交集
        List<Area> tempList = new ArrayList<>();

        while (!allAreas.isEmpty()) {
            // 记录覆盖最多区域的电台key
            String maxKey = null;
            int maxCoverCount = 0;// 记录最大覆盖区域的数量

            for (Map.Entry<String, Radio> entry : radioMap.entrySet()) {
                // 必须注意将tempList在此循环中清空
                tempList.clear();

                String key = entry.getKey();
                // 将电台的覆盖区域加入到临时区域集合中
                tempList.addAll(entry.getValue().coverAreas);
                // 取交集，并把交集结果赋给tempList
                tempList.retainAll(allAreas);

                // 如果交集不为空，则证明该电台有覆盖的区域
                // 第一次进来maxKey为null，将key赋值给maxKey
                // 第二次进来，比较key所代表的电台，和上一个maxKey所覆盖的集合大小进行比较
                int tempCoverCount = tempList.size();
                if (tempCoverCount > 0 &&
                        (maxKey == null || tempCoverCount > maxCoverCount)) {
                    maxKey = key;
                    maxCoverCount = tempCoverCount;
                }

            }
            // maxKey不为空，将maxKey对应的电台加入到结果集合中
            if (maxKey != null) {
                // 将maxKey对应的电台加入到结果集合中
                Radio maxRadio = radioMap.get(maxKey);
                radioList.add(maxRadio);
                // 将该maxKey覆盖的集合从allAreas中剔除
                allAreas.removeAll(maxRadio.coverAreas);
                // 将对应的maxKey的数据删除，因为已经覆盖过了，下次循环肯定无需再次遍历
                radioMap.remove(maxKey);
            }

        }

        for (Radio radio : radioList) {
            System.out.println("电台名：" + radio.name);
        }
    }

    /**
     * 贪心算法：集合覆盖问题：
     * 假如存在下表需要付费的广播电台，已经广播信号可以覆盖的区域
     * 广播台          覆盖地区
     * K1           北京，上海，天津
     * K2           广州，北京，深圳
     * K3           成都，上海，杭州
     * K4           上海，天津
     * K5           杭州，大连
     *
     * 思路分析：
     * 1.创建一个包含所有未覆盖区域的集合
     * 2.遍历所有电台，选择一个覆盖了最多未覆盖区域的电台
     * 3.从新创建的包含所有未覆盖区域的集合剔除 2 步骤选择的电台覆盖的区域
     * 4.重复2，3步骤，直到未覆盖区域的集合为空
     */

}

class Radio {
    String name;
    List<Area> coverAreas;

    public Radio(String name, List<Area> coverAreas) {
        this.name = name;
        this.coverAreas = coverAreas;
    }

    @Override
    public String toString() {
        return "Radio{" +
                "name='" + name + '\'' +
                ", coverAreas=" + coverAreas +
                '}';
    }
}

enum Area {
    BJ("北京"),
    SH("上海"),
    TJ("天津"),
    GZ("广州"),
    SZ("深圳"),
    CD("成都"),
    HZ("杭州"),
    DL("大连");

    String value;

    Area(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Area{" +
                "value='" + value + '\'' +
                '}';
    }
}