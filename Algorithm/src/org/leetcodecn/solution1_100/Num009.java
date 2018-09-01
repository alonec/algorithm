package org.leetcodecn.solution1_100;

/**
 * describe:  9. 回文数
 * 判断一个整数是否是回文数。
 *
 * @author alonec
 * @date 2018/08/30
 */
public class Num009 {
    public static void main(String[] args) {
//        int n = 0;
        int n = -1;
//        int n = 123321;
//        int n = 12321;
        System.out.println(method2(n));
//        System.out.println(method1(n));
    }

    /**
     *  不用转字符
     * @param x
     */
    private static boolean method2(int x){
        if (x < 0) return false;
        int help = 1;
        int len = 1;
        while(help <= x /10){
            help *= 10;
            len++;
        }
        int m = x;
        for (; len > 0; len--){
            if ( x %10 != m/help){
                return false;
            }
            x /= 10;
            m %= help;
            help /= 10;
        }
        return true;
    }
    /**
     * 暴力法：将输入的数转换为字符数组，再进行判断
     * 时间复杂度：O(n)
     * @param x 输入的整数
     */
    private static boolean method1(Integer x){
        if (x < 0) return false;
        if (x != null){
            String s = x.toString();
            char[] charInt = s.toCharArray();
            int length = charInt.length;

            for (int i=0, j=length - 1; i<=j; i++, j--){
                if (charInt[i] != charInt[j])
                    return false;
            }
            return true;
        }
        return false;
    }
}
