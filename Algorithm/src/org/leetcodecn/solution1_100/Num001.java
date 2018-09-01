package org.leetcodecn.solution1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: alonec
 * @Date: 2018/8/20
 * @Description: 1. 两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 */
public class Num001 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] arr = twoSumMapOnce(nums, 9);
        System.out.println(arr[0] + " , " + arr[1]);
    }

    /**
     * 暴力求解:O(n^2)
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = {-1, -1};
        if (nums == null)    return arr;
        for (int i=0; i<nums.length; i++){
            for (int j=i + 1; j<nums.length; ++j){
                if (target == nums[i]+ nums[j]){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
    /**
     * 两遍hash表
     * 时间复杂度：O(n)
     */
    public static int[] twoSumMapTwice(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        // 用hash表保存数组的元素和下标的映射关系.以下标作为value, 值作为key
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i=0; i<nums.length; i++){
            int tem = target - nums[i];
            if (map.containsKey(tem) && map.get(tem) != i){ // get方法返回的是value
                return new int[] {i, map.get(tem)};
            }
        }
        return null;
    }
    /**
     * 一遍hash表。更优化：其实就和我的暴力求解法，剔除了重复不需要查询的数（j = i+1, i前面的不用找了）
     *                  下面的也是这样，把它看做第一个解的解决方案与第二个解思路的合并。
     * 时间复杂度：O(n)
     */
    public static int[] twoSumMapOnce(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        // 用hash表保存数组的元素和下标的映射关系.以下标作为value, 值作为key
        for(int i=0; i<nums.length; i++){
            int tem = target - nums[i];
            if (map.containsKey(tem) && map.get(tem) != i){ // get方法返回的是value
                return new int[] {i, map.get(tem)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
