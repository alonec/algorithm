package org.leftgod01.day06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * describe: 贪心问题， 类似哈夫曼编码
 *
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的 金条，不管切成长度多大的两半，都要花费20个铜板。一群人想整分整块金 条，怎么分最省铜板？
 * 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60. 金条要分成10,20,30三个部分。 如果， 先把长度60的金条分成10和50，花费60 再把长度50的金条分成20和30，花费50 一共花费110铜板。
 * 但是如果， 先把长度60的金条分成30和30，花费60 再把长度30金条分成10和20，花费30 一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 *
 * @author alonec
 * @date 2018/08/21
 */
public class Demo1 {
    public static void main(String[] args) {
//        int[] arr = {30,90,10};
//        int[] arr = {10,20,30};
//        int[] arr = {};
        int[] arr = {10};
        int result = solution(arr);
        System.out.println(result);
    }
    public static int solution(int[] arr){
        if (arr == null || arr.length == 0)  return 0;
        int n = arr.length;
        if (n == 1)    return arr[0];
        PriorityQueue<Integer> maxHeap  = new PriorityQueue<>();
        int[] sum = new int[arr.length]; // 用来存放堆的非叶节点的值
        int k = 0;
        int root;
        for (int i=0; i<n; i++){
            maxHeap.offer(arr[i]);
        }
        int x = maxHeap.poll();
        int y = maxHeap.poll();
        root = x + y;
        sum[k++] = root;
        while ( !maxHeap.isEmpty()){
            sum[k++] = root + maxHeap.poll();
        }
        root = 0;
        for (int i=0; i<n; i++){
            root += sum[i];
        }
        return root;
    }
}
