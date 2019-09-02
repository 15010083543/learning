package com.arithmetic.array;

/**
 * @author LiuPeng
 * @description 稀疏数组与普通数组的转化
 * 使用场景
 * 有效数据远远少于无效数据的时候使用
 * 稀疏数组
 * 第一行第一列为原始数组的一维数组长度
 * 第一行第二列为原始数组的二维数组长度
 * 第一行第三列为有效数据有几个
 * 从第二行开始为数据的横纵轴坐标和数据值
 * @date 2019/9/1
 */
public class SparseArray {

    public static void main(String[] args) {
        // 原始普通的二维数组
        int originArray[][] = new int[11][11];
        originArray[1][2] = 1;
        originArray[2][3] = 2;
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (originArray[i][j] != 0) ++sum;
                System.out.printf("%d\t", originArray[i][j]);
            }
            System.out.println("");
        }
        System.out.println("-----------------------------");
        // 将原始数组转换为稀疏数组
        int sparseArray[][] = new int[3][sum + 1];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int count = 0;
        // 转化
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (originArray[i][j] != 0) {
                    sparseArray[++count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = originArray[i][j];
                }
            }
        }
        // 打印
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.printf("%d\t", sparseArray[i][j]);
            }
            System.out.println("");
        }
        System.out.println("------转化稀疏数组完成");
        // 稀疏数组转化原始数组
        count = 1;
        int originArrays[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 0; i < originArrays.length; i++) {
            for (int j = 0; j < originArrays[i].length; j++) {
                if (count <= sum && i == sparseArray[count][0] && j == sparseArray[count][1]) {
                    originArrays[i][j] = sparseArray[count][2];
                    count++;
                }
            }
        }
        // 打印
        for (int i = 0; i < originArrays.length; i++) {
            for (int j = 0; j < originArrays[i].length; j++) {
                System.out.printf("%d\t", originArrays[i][j]);
            }
            System.out.println("");
        }
    }
}
