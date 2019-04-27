package org.jzoffer;

public class 乘方问题 {
    public static void main(String[] args) {

        System.out.println(solution(-3, -1));

    }
    /*
     *  乘方问题：给定一个double类型的浮点数base和int类型的整数exponent。
     *  求base的exponent次方。
     */

    public static double solution01(double base, int exponent) {
        /*
         * 方法1：简单算法
         * 时间复杂度：O(n)
         * 运行时间： 51 ms 占用内存：10568K
         */

        double result = 1.0;
        if(base == 0)	// 0的任意次方都为0
            return 0;
        if(base == 1 || exponent == 0) // 1的任意整数次方都等于1。除开0外任何数的0次方都等于1
            return 1;
        if(exponent == 0)
            return 1;

        // 判断exponent的正负
        if(exponent >= 0) {
            for(int i=0; i<exponent; ++i) {  // 累乘
                result *= base;
            }
            return result;
        }
        else {
            exponent *= -1;
            for(int i=0; i<exponent; ++i) {  // 累乘
                result *= base;
            }
            return 1.0/result;
        }

    }
    public static double solution(double base, int exponent) {
        /*
         * 方法2：分治法解决乘方问题
         * 			if指数是偶数 则：base^exponent = base^(exponent/2)*base^(exponent/2)
         * 			if指数是奇数 则：base^exponent = base^(exponent/2)*base^(exponent/2)*base
         * 时间复杂度：O(lgn)
         * 运行时间：59ms	占用内存：10604k
         */
        double result = 1.0;
        if(base == 0)	// 0的任意次方都为0
            return 0;
        if(base == 1 || exponent == 0) // 1的任意整数次方都等于1。除开0外任何数的0次方都等于1
            return 1;
        if(exponent == 0)
            return 1;
        // 判断exponent的正负
        if(exponent >= 0) {
            if(exponent % 2 == 0) { // 偶数次方
                result = solution(base, exponent/2);// 向下取整
                result *= result;
            }else{	// 奇数次方
                result = solution(base, exponent/2);// 向下取整
                result = result * result * base;
            }

            return result;
        }else {
            exponent *= -1;
            if(exponent % 2 == 0) { // 偶数次方
                result = solution(base, exponent/2);// 向下取整
                result *= result;
            } else{	// 奇数次方
                result = solution(base, exponent/2);// 向下取整
                result = result * result * base;
            }
            return 1.0/result;
        }
    }
}

