package org.leetcodecn.day01;

/**
 * describe: 4. 两个排序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 你可以假设 nums1 和 nums2 不同时为空。
 *
 *@author alonec
 *@date 2018/08/20
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
//        int[] nums1 = {1};
//        int[] nums1 = {};
        int[] nums2 = {2,4};
//        int[] nums2 = {};

        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
    /**
     * 利用归并
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1 == null  ?  0: nums1.length;
        int n2 = nums2 == null  ?  0: nums2.length;
        int n = n1 + n2;
        if (n == 0) return 0;
        if (n == 1){
            if (n1 == 1) return nums1[0];
            if (n2 == 1) return nums2[0];
        }
        int[] help = new int[n];
        int i;
        int j;
        int k;
        i = j = k = 0;
        while (i < n1 && j < n2){
            help[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < n1){
            help[k++] = nums1[i++];
        }
        while (j < n2){
            help[k++] = nums2[j++];
        }
        int mid = (n - 1) / 2;
        return help.length % 2 == 0 ? ( help[mid] + help[mid + 1]) / 2.0 : help[mid];
    }
}
