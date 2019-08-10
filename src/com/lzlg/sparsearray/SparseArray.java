package com.lzlg.sparsearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SparseArray {
    public static void main(String[] args) throws Exception {
        // 1.创建二维数组，0：表示没有棋子，1：表示黑子 2：表示白子
        int rowCount = 11;
        int colCount = 11;
        int[][] chessArr = new int[rowCount][colCount];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 1;
        System.out.println("打印原始的二维数组============");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 2.二维数组转稀疏数组
        // 步骤：1)确定稀疏数组的大小
        int sum = 0; // 统计二维数组有效数据的数量
        for (int[] row : chessArr) {
            for (int data : row) {
                if(data != 0) {
                    sum++;
                }
            }
        }
        //      2)创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //      3)填充稀疏数组数据
        //          稀疏数组的第一行是二维数组的行数，列数，多少个数据
        //          稀疏数组的第二行是二维数组的第一个数据所在的行数，列数，数据值
        //          稀疏数据的第三行是二维数组的第二个数据所在的行数，列数，数据值
        //          以此类推
        sparseArr[0][0] = rowCount;
        sparseArr[0][1] = colCount;
        sparseArr[0][2] = sum;

        int pos = 0; // 用于记录起始行数
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if(chessArr[i][j] != 0) {
                    pos++;
                    sparseArr[pos][0] = i;
                    sparseArr[pos][1] = j;
                    sparseArr[pos][2] = chessArr[i][j];
                }
            }
        }

        //     4)打印稀疏数组
        System.out.println("二维数组转换成的稀疏数组是============");
        for (int[] row : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", row[0], row[1], row[2]);
        }

        // 3.稀疏数组转二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("打印从稀疏数组转换成的二维数组==============");

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 4.将稀疏数组转换成文件map.data
        FileWriter writer = new FileWriter(new File("C:\\Users\\lzlg5\\Downloads\\map.data"));
        for (int[] row : sparseArr) {
            writer.write(row[0] + "\t" + row[1] + "\t" + row[2] + "\n");
        }
        writer.close();
        // 5.将文件map.data转换成稀疏数组
        BufferedReader reader = new BufferedReader(new FileReader(new File(
                "C:\\Users\\lzlg5\\Downloads\\map.data")));
        int[][] sparseArr2 = null;
        String str = null;
        int index = 0;
        while((str = reader.readLine()) != null) {
            String[] array = str.split("\t");
            if(sparseArr2 == null) {
                sparseArr2 = new int[Integer.parseInt(array[2]) + 1][3];
            }
            sparseArr2[index][0] = Integer.parseInt(array[0]);
            sparseArr2[index][1] = Integer.parseInt(array[1]);
            sparseArr2[index][2] = Integer.parseInt(array[2]);
            index++;
        }

        reader.close();

        System.out.println("打印从map.data文件中读取的稀疏数组============");

        for (int[] row : sparseArr2) {
            System.out.printf("%d\t%d\t%d\t\n", row[0], row[1], row[2]);
        }
    }
}
