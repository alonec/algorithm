package org.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * | 1， 2， 3，  4|
 * | 5， 6， 7，  8|
 * |9， 10，11， 12|
 * |13，14，15，16|
 *
 */
public class Number_19 {
    public static void main(String[] args) {
         //int [][]matrix = {{1, 2 ,3, 4},{ 5, 6, 7, 8},{ 9, 10, 11, 12}, {13, 14, 15, 16}};
         //int [][]matrix = {{1}};
        //int [][]matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        //int [][] matrix = null;
        int [][]matrix = {{1},{2},{3},{4},{5}};
        List<Integer> list = new Number_19().printMatrix(matrix);

        for (Integer i: list
             ) {
            System.out.println(i);
        }
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList <Integer>();

        int n = matrix.length; //行数
        int m = matrix[0].length; // 列数
        int layers = (Math.min(n,m)-1)/2+1;//这个是层数
        for(int k=0; k<layers; ++k){
           for(int j=k; j<m-k; ++j){ //m次循环，一行有m个数
               list.add(matrix[k][j]);
           }
           for(int i=k+1; i<n-k;++i ){// n-1次循环，一列有n个数，但是上面输出“一行”时，已经输出过了
               list.add(matrix[i][m-1-k]);
           }
           for(int j=m-k-2; (j>=k)&& k!=(n-k-1); --j){  //为了避免和上一层最后一个元素重复，故列数在向左偏移一个
               list.add(matrix[n-k-1][j]);
           }
           for(int i=n-k-2; (i>k)&&k!=(m-k-1); --i){ // 不能和起始是同一列，避免重复
               list.add(matrix[i][k]);
           }
        }
        return list;
    }

}
