package org.leetcodecn.solution201_300;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 存在重复元素
 */
public class Num219 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
//        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(method(nums, k));
    }
    public static boolean method(int[] nums, int k){
        List<Integer> list = new ArrayList<>(k); // 查找表
        for (int i = 0; i < nums.length; i++) {
            if ( !list.isEmpty() && list.size() <= k && list.contains(nums[i])){
                return true;
            }
            list.add(nums[i]);
            // 保证查找表长度为k
            if (list.size() == k+1){
                list.remove(i - k);
            }
        }
        return false;
    }

}
