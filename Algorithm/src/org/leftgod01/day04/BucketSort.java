package org.leftgod01.day04;

/**
 * @Auther: chenxin
 * @Date: 2018/8/9 01:40
 * @Description: 桶排序扩展————排序后的最大相邻数差值问题
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {17, 13, 0, 41, 49, 69};
        int result = new BucketSort().sort(arr);
        System.out.println(result);
    }
    public int sort(int[] arr){
        if (arr == null || arr.length < 2)
            return 0;
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // 求出最小值和最大值
        for(int i=0; i< n ; ++i){
            max = Integer.max(arr[i], max);
            min = Integer.min(arr[i], min);
        }
        if (max == min) return 0;
        //
        boolean[] hasNumber = new boolean[n + 1]; // 记录桶中有没有元素
        int[] maxs = new int[n + 1];              // 每个桶中最大的元素
        int[] mins = new int[n + 1];              // 每个桶中最小的元素
        int bid;
        for (int i=0; i<n; ++i){
            bid = bucket(arr[i], n, max, min); // 计算出元素位于那个桶
            maxs[bid] = hasNumber[bid] ? Math.max(arr[i] , maxs[bid]):arr[i];
            mins[bid] = hasNumber[bid] ? Math.min(arr[i] , mins[bid]):arr[i];
            hasNumber[bid] = true;
        }
        int lastMax = maxs[0]; // 存放上一个非空桶的最大值
        int res = 0;           // 记录最大差值
        for ( int i=0; i<=n; ++i){
            if (hasNumber[i]){ // 桶非空
                res  = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;


    }
    /**
     *@描述 计算元素在桶中的位置（在哪个桶里面）
     *@param
     * @return:
     */
    public int bucket(long number,long n, long max, long min){
        return (int) ((int)(number - min) * n / (max - min));
    }


}
