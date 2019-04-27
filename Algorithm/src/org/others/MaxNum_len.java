package org.others;
import java.util.Scanner;
/**
 * describe: 输入字符串，输出字符串中连续最长的数字串。
 *
 * @author alonec
 * @date 2018/09/15
 */

public class MaxNum_len {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(method(str));
    }
    public static int method(String str){
        int maxNum_len = 0; // 最长的数字串的长度
        int count = 0;// 统计当前数字串的长度
        int index_end = 0; // 数字串的结尾的后一个位置
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                count ++;
                if(i == str.length() - 1 && count > maxNum_len) { // 如果字符串没到尾部，且发现更长的字符串数字
                    maxNum_len = count;
                    index_end = i + 1;
                }
                continue; // 跳过count = 0
            }
            if(count > maxNum_len) {  // 字符串到了尾部。此时i = str.length();也满足数字串结尾的后一个位置
                maxNum_len = count;
                index_end = i;
            }
            count = 0;
        }
        return Integer.valueOf(str.substring(index_end - maxNum_len, index_end));
    }
}
