package org.leftgod01.day05;

/**
 * @Auther: chenxin
 * @Date: 2018/8/13 15:51
 * @Description:
 */
public class Juzhen_Circle {
    public static void main(String[] args) {
//        int[][] arr = {{1,2,4,5}, {3, 2, 1, 1}, {5, 6, 7, 8 }};
        int[][] arr = {{1}};
//        int[][] arr = {};
        new Juzhen_Circle().printMatrixWithCircle(arr);
    }
    public void printMatrixWithCircle(int[][] arr){
        if (arr == null || arr.length < 1) return;
        int row1, row2, col1, col2;
        row1 = 0;
        col1 = 0;
        row2 = arr.length - 1;
        col2 = arr[0].length - 1;
        while (row1 <= row2 && col1 <= col2){
            printCircle(arr, row1++, col1++, row2--, col2--);
        }
    }
    public void printCircle(int[][] arr, int row1, int col1, int row2, int col2){
        if (row1 == row2){
            while (col1 <= col2){
                System.out.print("  " + arr[row1][col1++]);
            }
        }
        else if (col1 == col2){
            while (row1 <= row2){
                System.out.print("  " + arr[row1++][col1]);
            }
        }else {
            while (col1 < col2){
                System.out.print("  " + arr[row1][col1++]);
            }
            while (row1 < row2){
                System.out.print("  " + arr[row1++][col1]);
            }
            while (col1 > 0){
                System.out.print("  " + arr[row1][col1--]);
            }
            while (row1 > 0){
                System.out.print("  " + arr[row1--][col1]);
            }
        }
        System.out.println();
    }
}
