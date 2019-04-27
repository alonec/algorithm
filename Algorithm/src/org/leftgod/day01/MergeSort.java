package org.leftgod.day01;

/**
 * 八大排序之归并排序
 * 外部排序：因为在合并时，需要一个额外的数组
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)-----因为用了一个辅助数组
 *
 * 这里面要注意，求两个数的中点时，注意溢出问题
 * int mid = (L + R) / 2; // 这种方法不安全，当数很大的时候，(L+R)可能会大于int最大值，导致溢出
 * int mid = L + (R - L) / 2;
 */
public class MergeSort {
    public static void main(String[] args) {
        int []arr = {3,2,5,8,4,9};
        mergeSort(arr);
        for (int i: arr) {
            System.out.print(i + ", ");
        }
    }
    public static void mergeSort(int []arr){
        if (arr == null || arr.length < 2)
            return;
        divide(arr, 0, arr.length - 1);

    }
    public static void divide(int arr[], int L, int R){
        if (L ==  R)
            return;
        // int mid = (L + R) / 2; // 这种方法不安全，当数很大的时候，(L+R)可能会大于int最大值，导致溢出
        int mid = L + (R - L) / 2;
        divide(arr, L, mid);
        divide(arr, mid + 1, R);
        merge(arr, L, mid, R);

    }
    public static void merge(int []arr, int L, int M, int R){
        // B[2,3,  1,7]
        int []b = new int[R - L + 1];
        int p1 = L;
        int p2 = M+1;
        int i = 0;
        while (p1 <= M && p2 <= R )
            b[i++] = arr[p1] <= arr[p2] ? arr[p1++]:arr[p2++];
        // 两个肯定有一个是没有放完的
        while (p1 <= M)
            b[i++] = arr[p1++];
        while (p2 <= R)
            b[i++] = arr[p2++];
        // 拷贝回数组arr
        for (i = 0; i < b.length; ++i)
            arr[L + i] = b[i];  // 因为起点是L，所以加上 L
    }
}
