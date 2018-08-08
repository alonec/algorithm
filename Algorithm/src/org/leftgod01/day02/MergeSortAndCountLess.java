package org.leftgod01.day02;

/**
 * @Auther: chenxin
 * @Date: 2018/8/6 00:58
 * @Description:    求一组序列（无序），每个数左边比自己小的数的数量
 */
public class MergeSortAndCountLess {

    private static int cnt = 0;
    public static void main(String[] args) {
        int []arr = {3,2,5,8,4,9};
        new MergeSortAndCountLess().sort(arr);
        for (int i: arr) {
            System.out.print(i + ", ");
        }
        System.out.println("-----------------");
        System.out.println(cnt);
    }
    public void sort(int[] arr){
        if (arr == null || arr.length <= 2) return;
        divide(arr, 0, arr.length - 1);
    }
    public void divide(int[] arr, int L, int R){
        if ( arr == null || L >= R){
            return;
        }
        int mid = L + (R - L) / 2;
        divide(arr, L, mid);
        divide(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
    /**
     * 功能描述: 合并数组
     *  {3,2,5,8,4,9}
     */
    public void merge(int []arr, int L, int mid,  int R){
        int[] help = new int[R - L + 1]; //辅助数组
        int low = L;
        int high = mid + 1;
        int i = 0;
        while ( low <= mid && high <= R ){
            if (arr[low] <= arr[high]){
                help[i++] = arr[low++];
                cnt += R - high + 1;
            }else{                          // 左比右小， 那么从high位置起，它的右边的数都大于该数：(R - high + 1)
                help[i++] = arr[high++];
            }
        }
        while (low <= mid){
            help[i++] = arr[low++];
        }
        while (high <= R){
            help[i++] = arr[high++];
        }
        for (i = 0 ; i < help.length; ++i){
            arr[i + L] = help[i];
        }
    }
}
