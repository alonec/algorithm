package org.jzoffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 思路：辅助内存：一个和原数组大小一样的数组tem[array.length]
 *       如果是奇数，则放入tem数组（从前往后放）
 *       如果是偶数，则从后往前放
 *       最后放回原数组中
 *       时间复杂度：O(n)
 *
 */
public class Number_13 {
    public static void main(String[] args) {
       int array[] = {1,3,2,5,4,8,12};
        reOrderArray(array);
        for (int e:array
             ) {
            System.out.print(e);
        }

    }
    public static void reOrderArray(int [] array) {
        int n=array.length;
        int []tem = new int[n];
        int l,r;
        l = 0;
        r = n-1;
        for(int i=0; i<n; ++i){ // 遍历原数组
            if(array[i] %2 == 1){ // 奇数
                tem[l] = array[i];
                l++;
            }else {
                tem[r] = array[i];
                r--;
            }
        }
        for(int i=0; i<l; ++i){
            array[i] = tem[i];
        }
        for(int i=n-1; i>r; --i){
            array[l] = tem[i];
            l++;
        }
    }
}