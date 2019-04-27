package org.leetcodecn.solution201_300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口最大值
 */
public class Num239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        // output: [3,3,5,5,6,7]
        int[] result = method(nums,k);
        for (int i: result
             ) {
            System.out.print(" ");
            System.out.print(i);
        }
    }
    public static int[] method(int[] nums, int k){
        LinkedList<Integer> queue = new LinkedList(); // 双端队列
        int n = nums.length;
        int[] result = new int[n - k + 1]; // 存储结果
        for (int i = 0; i < n; i++) {
            // 保证队首元素最大，且递减。这样使滑框的最大数就是队列首元素
            while ( !queue.isEmpty() && nums[i] > nums[queue.peekLast()]){
                queue.removeLast();
            }
            queue.addLast(i);
            // 保证元素没有超出滑框范围
            if ( queue.peekFirst() == i - k){
                queue.removeFirst();
            }
            // 记录每个滑框的最大值
            if (i>= k - 1){
                result[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return result;
    }
}
