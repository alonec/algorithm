package org.others;
/*
 * 打印1-1000以内的素数
 * 素数：除1以外的只能被1和本身整除的自然数
 */
public class 一千内的素数 {
    public static void main(String[] args) {
        int n = 1000;
        for (int i = 3; i < n; i+=2) { // 因为偶数都能被2整除，所以只考虑奇数
            boolean flag = true;
            for (int j = 3; j <= Math.sqrt(i); j++) { // 此处取巧将j的范围缩减到了i的平方根内（直接除2不好）。
                if (i % j == 0){
                    flag = false;
                }
            }
            if (flag){
                System.out.println(i);
            }
        }
    }
}
