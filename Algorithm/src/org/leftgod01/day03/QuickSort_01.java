package org.leftgod01.day03;

public class QuickSort_01 {
    // [....2, 5, 0, 3, 7, 9, 8, 4....]
    public static void main(String[] args) {
        int[] a = {6, 3, 8, 2, 1, 10, 5};
        new QuickSort_01().quicksort01(a, 0, 6);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
    /**
     * 经典快排（朴素算法）
     * @param arr
     * @param L
     * @param R
     */
    public void quicksort01(int []arr, int L, int R){
        if ((arr == null) || (R - L < 1)) return;
        int mid = partition(arr, L, R);
        quicksort01(arr, L, mid-1);
        quicksort01(arr, mid +1, R);
    }
    public int partition(int []arr, int L, int R){
        int less = L - 1;
        while(L <= R){
            if (arr[L] <= arr[R])  swap(arr, ++less, L);// 将小与等于基准的数放到前面来，并且less向后移动一个
            L++;
        }
        return less;
    }
    public void swap(int []arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}
