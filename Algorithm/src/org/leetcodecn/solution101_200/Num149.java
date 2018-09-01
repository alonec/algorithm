package org.leetcodecn.solution101_200;

import java.util.HashMap;

/**
 * 149. 直线上最多的点数
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 */
class Point {
    int x;
    int y;
    Point() {
        x = 0;
        y = 0;
    }
    Point(int a, int b) {
        x = a;
        y = b;
    }
}
/**
 * 1. 列出所有点集（两个点的集合，不重复），用两个for循环
 * 2. 用HashMap<String, Integer> String是斜率 k（字符型，首先斜率是不能用double表示的，不准确，还要注意分母不能为零）
 *      2.1 求出k, 可以用公约数gcd函数可以求，但是它只能求两个正整数的最大公约数，所以要进行更改
 *          public int gcd(int a, int b) {
 *              if (b == 0)
 *                  return a;
 *              else
 *              return gcd(b, a % b);
 *          }
 *      2.2 求斜率的字符表示（这里要考虑符号的正负，用你另一个函数首先判断斜率的分子分母）
 * 3. 注意从point[ ,i]开始的点作为直线的起点，如果后面的点与其重合，则单独记录下来。
 *     如果不重合，则根据斜率，也就是查找Map中是否包含，键为该斜率的元素。包含则对其value加一，否则将其作为新的键，1作为value存储下来
 * 4. 判断该键为该斜率的value值和maxInner谁大，maxInner用来存储一次内循环的直线上最多的点
 * 5. maxPiontCount用来直线上最多的点
 */
public class Num149 {
    public int maxPoints(Point[] points) {
        int length = points.length;
        int maxPoints = 0;
        if (length <= 1)
            return length;
        for(int i=0; i<length; ++i){ // 穷举出所有点集
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int maxInner = 0;
            int commonPoint = 1; // 记录重合的点的个数
            Point cur = points[i];//起点
            for(int j=i+1; j<length; ++j){
                Point iter = points[j];
                if(cur.x == iter.x && cur.y==iter.y){    // 点重合
                    commonPoint++;
                }else{
                    String key = getSlope(cur, iter); //直线斜率
                    map.put(key, map.containsKey(key)?map.get(key)+1:1);
                    maxInner = Math.max(maxInner, map.get(key)); // 因为map存的value变化了，所以重新记录最大的点数
                }
            }
            maxInner = commonPoint + maxInner;
            maxPoints = Math.max(maxInner, maxPoints);
        }
        return maxPoints;
    }

    /**
     * 求斜率
     * @param cur
     * @param iter
     * @return  String
     */
    public String getSlope(Point cur, Point iter) {
        int numerator = iter.y - cur.y;
        int denominator = iter.x - cur.x;
        String sign = getSign(numerator, denominator);
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));//0和任意一个非零数'a'的gcd为'a',0和0的gcd为0,所以斜率为无穷的情况分母为0
        return sign + Math.abs(numerator)/gcd + "/" + Math.abs(denominator)/gcd;
    }

    /**
     * 求斜率的正负
     * @param a
     * @param b
     * @return
     */
    public String getSign(int a, int b) {
        if (a <= 0 && b <= 0 || a >= 0 && b >= 0)
            return "+";
        else
            return "-";
    }
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

}
