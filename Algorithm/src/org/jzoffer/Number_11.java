package org.jzoffer;

public class Number_11 {
    /**
     * 思路：用1，与n的二进制每一位都进行&操作（结果为1则n的此位置为1，为0则是0）
     */
    public int NumberOf(int n) {
        int help = 1;
        int count = 0;
        while(help != 0){
            if ((n & help) != 0){
                count++;
            }
            help = help << 1; //将help左移一位，对应上n的每个位置
        }
        return count;
    }
    /**
     * 思路：关键是 n = n & (n - 1) ，将n的二进制形式最右边的1变为0。这样每次删除一个1，直到n=0
     */
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n - 1); //将n的二进制形式最右边的1变为0
        }
        return count;
    }
}
