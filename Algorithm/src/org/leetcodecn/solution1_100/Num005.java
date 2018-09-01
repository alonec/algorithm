package org.leetcodecn.solution1_100;

/**
 * describe: 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * @author alonec
 * @date 2018/08/31
 */
public class Num005 {
    /**
     * 最长公共子串
     * @param str
     * @return 返回最长的回文字符串
     */
//    private static String method1(String str){
//
//    }private static String method1(String str){
////
////    }
    private static boolean checkPlalindrome(char[] chars, int begin, int end){
        while (begin < end) {
            if (chars[begin] != chars[end]){
                return false;
            }
        }
        return true;
    }
}
