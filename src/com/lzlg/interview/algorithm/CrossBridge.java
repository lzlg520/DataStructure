package com.lzlg.interview.algorithm;

/**
 * 小明一家要过一座桥，过桥的时候是黑夜，必须要有灯。
 * 小明过桥要1分钟，小明弟弟要3分钟，小明爸爸要6分钟
 * 小明妈妈要8分钟，小明的爷爷要12分钟，
 * 每次此桥最多可过两人，而过桥的速度根据过桥者最慢者而定
 * 而且灯在点燃后30分钟就会熄灭，请问小明已经如何过桥时间最短？
 * 每次过完桥都得有个人返回，把灯拿到桥的另一边，直到最后一次
 */
public class CrossBridge {
    static int index; // 过桥临时方案的数组下标
    static int size = 64;
    static int N = 5;
    static int minTime = 30; // 最小过桥时间总和，初始值30
    static int[] transit = new int[size]; // 进行下标中转的数组
    static int[] program = new int[size]; // 最短时间内过桥的方案
    static int[] time = {1, 3, 6, 8, 12}; // 每个人过桥需要的时间

    // 每个人的位置信息，0：在桥左边，1：在桥右边
    // 下标分别对应 0：小明，1：弟弟，2：爸爸，3：妈妈，4：爷爷
    static int[] location = new int[N];

    public static void main(String[] args) {
        // 初始方案内容为负值，避免和人员标号 冲突
        for (int i = 0; i < size; i++) {
            program[i] = -1;
            transit[i] = -1;
        }
        find(N, 0, 1);// 查找最佳方案
        System.out.println("最短过桥时间为：" + minTime);
        System.out.println("最佳过桥组合为：");
        for (int i = 0; i < size && program[i] >= 0; i += 3) {
            System.out.println(program[i] + "-" + program[i + 1] + " " + program[i + 2]);
        }
    }

    /**
     * @param notPass   未过桥人数
     * @param usedTime  当前已用时间
     * @param direction 过桥方向，1--向右，0--向左
     */
    private static void find(int notPass, int usedTime, int direction) {
        if (notPass == 0) {// 所有人已过桥，更新最少时间及方案
            minTime = usedTime;
            for (int i = 0; i < size && transit[i] >= 0; i++) {
                program[i] = transit[i];
            }
        } else if (direction == 1) {// 过桥方向向右，从桥左侧选出二人过桥
            for (int i = 0; i < N; i++) {
                if (location[i] == 0 && (usedTime + time[i] < minTime)) {
                    transit[index++] = i;
                    location[i] = 1;
                    for (int j = 0; j < N; j++) {
                        int tempMax = (time[i] > time[j]) ? time[i] : time[j];
                        if (location[j] == 0 && (usedTime + tempMax < minTime)) {
                            transit[index++] = j;
                            location[j] = 1;
                            find(notPass - 2, (usedTime + tempMax), 0);
                            location[j] = 0;
                            transit[--index] = -1;
                        }
                    }
                    location[i] = 0;
                    transit[--index] = -1;
                }
            }

        } else {
            for (int i = 0; i < N; i++) {
                if (location[i] == 1 && usedTime + time[i] < minTime) {
                    transit[index++] = i;
                    location[i] = 0;
                    find(notPass + 1, usedTime + time[i], 1);

                    location[i] = 1;
                    transit[--index] = -1;
                }
            }
        }
    }
}
