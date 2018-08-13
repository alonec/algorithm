package org.leftgod01.day05;

/**
 * @Auther: chenxin
 * @Date: 2018/8/13 14:11
 * @Description: 给一个矩阵，按之字型打印
 */
public class Juzhen_Zhizi {
    public static void main(String[] args) {
       // int[][] arr = {{1,2,4,5}, {3, 2, 1, 1}, {5, 6, 7, 8 }};
//        int[][] arr = {{1}};
        int[][] arr = {};
        new Juzhen_Zhizi().printMatrixWithZhi(arr);
    }
    public void printMatrixWithZhi(int[][] arr){
        if (arr == null || arr.length < 1) return;
        int row = arr.length - 1;
        int col = arr[0].length - 1;
        int row1, row2, clo1, clo2;
        row1 = row2 = 0;
        clo1 = clo2 = 0;
        boolean tag = false;
        /*if (row1 == row && clo1 == col){
            System.out.print("  " + arr[row][col]);
        }*/
        while (row1 <= row && clo2 <= col){
            printLine(arr, row1, clo1, row2, clo2, tag);
            if (clo1 != col)    clo1++;
            else row1++;
            if (row2 != row)    row2++;
            else clo2++;
            tag = !tag;
        }
    }
    public void printLine(int[][] arr, int row1, int col1, int row2, int col2 , boolean tag){
        if (tag){
            while (row1 <= row2 && col1 >= col2){
                System.out.print("  "+ arr[row1++][col1--]);
            }
        }else {
            while (row1 <= row2 && col1 >= col2){
                System.out.print("  "+ arr[row2--][col2++]);
            }
        }

    }
}
