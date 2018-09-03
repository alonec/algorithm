package org.leetcodecn.solution1_100;

/**
 * describe: 7. 反转整数
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
 * 根据这个假设，如果反转后的整数溢出，则返回 0。
 * @author alonec
 * @date 2018/08/21
 */
public class Num007 {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0; // 反转后溢出，返回0
        int t = 1;
        if (x < 0) {
            t = -1;
            x *= -1;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        if (t < 0) {
            sb.append("-");
        }
        for (int i=chars.length - 1; i>=0; i--) {
            sb.append(chars[i]);
        }
        long n = Integer.valueOf(sb.toString());
        if (t > 0){
            return n > Integer.MAX_VALUE ? 0 : (int)n;
        }else {
            return n< Integer.MIN_VALUE ? 0 : (int)n;
        }

    }
}
