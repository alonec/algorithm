package org.leetcodecn.solution1_100;

import java.util.Stack;

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
    /**
     * 弹出和推入数字 & 溢出前进行检查
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
