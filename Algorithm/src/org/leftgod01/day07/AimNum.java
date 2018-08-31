package org.leftgod01.day07;

import java.util.Arrays;

/**
 * describe: 进阶班第一章第二题
 * 给定一个数组arr，和一个整数aim，请返回哪两个位置的数可以加出aim来。
 * 1. 无重复
 * 2. 有重复
 * 3. 三数
 * @author alonec
 * @date 2018/08/30
 */
public class AimNum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int aim = 9;
        int[] result = method2(arr, aim);
//        int[] result = method1(arr, aim);

        if (result != null){
            System.out.println(arr[result[0]] +"   "+arr[result[1]]);
        }else {
            System.out.println(result);
        }
    }

    /**
     * 无重复的
     * @param arr
     * @param aim
     * @return
     */
//    public static int[] method3(int[] arr, int aim) {
//
//
//    }

    /**
     * 双指针联动
     * @param arr
     * @param aim
     * @return
     */
    public static int[] method2(int[] arr, int aim){
        if (arr != null){
            int L = 0;
            int R = arr.length - 1;
            Arrays.sort(arr);
            while (L < R){
                if (arr[L] + arr[R] < aim){
                    L++;
                }else if (arr[L] + arr[R] > aim){
                    R--;
                }else {
                    return new int[] {L, R};
                }
            }
        }
        return null;
    }

    /**
     * 暴力穷举法 时间复杂度：O(n^2)
     * @param arr 输入数组
     * @param aim 目标数字
     */
    private static int[] method1(int[] arr, int aim){
        if (arr == null) return null;

        int len = arr.length;
        for (int i=0; i<len; i++){
            for (int j=i+1; j<len; j++){
                if (arr[i] + arr[j] == aim){
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
