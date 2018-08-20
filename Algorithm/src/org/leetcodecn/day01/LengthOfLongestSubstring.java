package org.leetcodecn.day01;/**
 * @Auther: chenxin
 * @Date: 2018/8/20 19:42
 * @Description:
 */

import java.util.*;

/**
 *describe: 3. 无重复字符的最长子串
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 *@author alonec
 *@date 2018/08/20
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
//        String s = " ";
        String s = "";

//        int length = lengthOfLongestSubstring(s);
        int length = solution2(s);
        System.out.println(length);
    }
    /**
     * 使用hash表
     * 时间复杂度：O(n).比第二个更优
     */
    public static int solution2(String s){
        if (s == null || s.equals("") )    return 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>(); // 以字符为key，下标为value
        for (int i=0, j=0; j<s.length(); ++j){ // i为左边界，j为又边界
            // hash表的contains方法时间复杂度为O(1)
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i); // 移动 i
            }
            // 左闭右开，此处用j+1
            map.put(s.charAt(j), j + 1);
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
    /**
     * 时间复杂度：O(2n)
     * 空间复杂度：O(Min(n + m))字符串 n以及字符集/字母 m
     * 较第一个解，主要是节省了contains方法查询的时间
     */
    public static int solution(String s){
        if (s == null || s.equals("") )    return 0;
        int maxLength = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int i;
        int j;
        i = j = 0;  // i, j作为滑块区间（左闭右开）
        while (i < n && j < n){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j - i);
            }else{
                set.remove(s.charAt(i++)); // 本来担心在这样写的话，只能移除一个元素。
                                            // 但i ， j是没关系的，这样，也能达到第一个思路的滑动的效果。
            }
        }
        return maxLength;
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("") )    return 0;
        Queue<Character> queue = new LinkedList<>(); // 利用队列的先进先出特性，找最长的无重复子序列
        char[] array = s.toCharArray();
        int maxLength = Integer.MIN_VALUE;
        for (int i=0; i<array.length; ++i){
            if (queue.contains(array[i])){  // contains()方法时间复杂度为O(n),那么该算法：O(n^2)
                while (queue.peek() != array[i]){
                    queue.poll();
                }
                queue.poll();
            }
            queue.offer(array[i]);
            Math.max(maxLength, queue.size());
        }
        return maxLength;
    }

}
