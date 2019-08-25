package com.lzlg.interview.algorithm;

/**
 * 8皇后问题
 */
public class EightQueen {
    static int count = 0;

    public static void main(String[] args) {
        int[][] pawn = new int[8][8];
        int i, cols;
        for (i = 0; i < 8; i++) {
            for (cols = 0; cols < 8; cols++) {
                pawn[i][cols] = 0;
            }
        }
        int count = solving(0, 8, pawn);
        System.out.println("The number of the answer for solving is " + count);
    }

    private static int solving(int row, int cols, int[][] pawn) {
        int j;
        int[][] tempPawn = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                tempPawn[i][j] = pawn[i][j];
            }
        }

        if (row == 8) {
            System.out.println("第" + (count + 1) + "种方法：");
            for (int i = 0; i < 8; i++) {
                for (int l = 0; l < 8; l++) {
                    System.out.print(tempPawn[i][l]);
                }
                System.out.println();
            }
            count++;
        } else {
            for (j = 0; j < cols; j++) {
                if (isPlaced(row, j, pawn)) {
                    for (int i = 0; i < 8; i++) {
                        tempPawn[row][i] = 0;
                    }
                    tempPawn[row][j] = 1;
                    solving(row + 1, cols, tempPawn);
                }
            }
        }
        return count;
    }

    private static boolean isPlaced(int row, int cols, int[][] pawn) {
        int i, k;
        boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false;
        for (i = 0; i < 8; i++) {
            if (pawn[i][cols] != 0) {
                flag1 = true;
                break;
            }
        }

        for (i = row, k = cols; i >= 0 && k >= 0; i--, k--) {
            if (pawn[i][k] != 0) {
                flag2 = true;
                break;
            }
        }

        for (i = row, k = cols; i < 8 && k < 8; i++, k++) {
            if (pawn[i][k] != 0) {
                flag3 = true;
                break;
            }
        }

        for (i = row, k = cols; i >= 0 && k < 8; i--, k++) {
            if (pawn[i][k] != 0) {
                flag4 = true;
                break;
            }
        }

        for (i = row, k = cols; i < 8 && k >= 0; i++, k--) {
            if (pawn[i][k] != 0) {
                flag5 = true;
                break;
            }
        }

        if (flag1 || flag2 || flag3 || flag4 || flag5) {
            return false;
        } else {
            return true;
        }
    }
}
