package org.leftgod.day05;

/**
 * @Auther: chenxin
 * @Date: 2018/8/13 21:26
 * @Description: 在行列都排好序的矩阵中找数
 * 【题目】 给定一个有N*M的整型矩阵matrix和一个整数K，matrix的每一行和每一 列都是排好序的。
 * 实现一个函数，判断K是否在matrix中。
 * 例如： 0   1   2   5
 *        2   3   4   7
 *        4   4   4   8
 *        5   7   7   9
 * 如果K为7，返回true；如果K为6，返回false。
 * 【要求】 时间复杂度为O(N+M)，额外空间复杂度为O(1)。
 * 【思路】 类似于归并排序的combine过程
 */
public class FindNumInMatrix {
    public static void main(String[] args) {
//        int[][] arr = {{0,   1,   2,  5}, {2,   3 ,  4 ,  7}, {4,   4 ,  4,   8}, {5,   7,   7,   9}};
//       System.out.println(new FindNumInMatrix().find(arr, 6));
//        System.out.println(new FindNumInMatrix().find(arr, 5));
//        int[][] arr = {};
//        int[][] arr = null;
        int [][] arr = {{1}};
        System.out.println(new FindNumInMatrix().find(arr, 1));


    }
    public boolean find(int[][] arr, int k){
        if (arr == null || arr.length < 1)    return false;
        int row = 0;
        int col = arr[0].length - 1;
        while (row < arr.length && col >= 0){
            if ( k == arr[row][col])    return true;
            else if (k < arr[row][col]){
                col--;  // 那么col这一列，都是大于k的。排除
            }else {
                row++;  // 那么row这一行，都是小于k的。排除
            }
        }
        return false;
    }
}
