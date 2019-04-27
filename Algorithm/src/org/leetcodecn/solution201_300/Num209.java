package org.leetcodecn.solution201_300;

/**
 * 长度最小的子数组
 */
public class Num209 {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        // output: 2, 子数组[4,3]，是该条件下的长度最小的连续数组
        System.out.println(method(s, nums));
    }
    public static int method(int s, int[] nums){
        int left, right;
        int sum = 0;
        int result = nums.length;
        left = 0;
        right = 0;
        while (right < nums.length){
            if (right + 1 < nums.length && sum < s){
                sum += nums[right];
                right++;
            }else if (right >= left){
                if (right - left < result){
                    result = right - left;
                }
                sum -= nums[left];
                left++;
            }
        }
        return result;
    }
}
