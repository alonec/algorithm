package org.leftgod01.day06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * describe: 贪心问题
 *
 * 输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，正数k 参数4，正数m
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润),也就是说，成本也能回来
 * k表示你不能并行、只能串行的最多做k个项目
 * m表示你初始的资金
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
 *
 * 输出： 你最后获得的最大钱数。
 *
 * @author alonec
 * @date 2018/08/21
 */
class Temp {
    Integer index;
    Integer val;
    public Temp(Integer index, Integer cos) {
        this.index = index;
        this.val = cos;
    }
}
public class Demo2 {
    public static void main(String[] args) {
        int[] costs = {2, 3, 5, 8};
        int[] profits = {3, 2, 6, 7};
        int k = 1;
//        int k = 6;
        int m = 1;
//        int m = 8;
        int result = solution(costs, profits, k, m);
        System.out.println(result);
    }
    public static int solution(int[] costs, int[] profits, int k, int m){
        PriorityQueue<Temp> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        // 将所有的i号项目的花费排序（小根堆）
        for (int i=0; i<costs.length; i++){
            minHeap.offer(new Temp(i, costs[i]));
        }
        for ( ; k > 0; --k) {
            // 将所有符合的项目都放入大根堆中
            while ( !minHeap.isEmpty() && minHeap.peek().val <= m){
                maxHeap.offer(profits[minHeap.poll().index]);
            }
            if (maxHeap.isEmpty())    break;    // 项目都做完了
            m += maxHeap.poll();  // 完成一次项目后的资金数
        }
        return m;
    }
}
