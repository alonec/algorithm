package org.leftgod01.day03;

/**
 * @Auther: chenxin
 * @Date: 2018/8/7 02:44
 * @Description: 随机快排
 */
public class QuickSort03 {

    // [...3,4,5,0,6,4...]
    public static void main(String[] args) {
        int[] a = {6, 3, 8, 6, 1, 6, 5};
        new QuickSort_01().quicksort01(a, 0, 6);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
    public void sort(int []arr, int L, int R){
        if (L < R){
            swap(arr, (int)(L + (Math.random() * (R - L + 1) ))+ L, R);
            int[] mid = partition(arr, L, R);
            int mid_Low = mid[0];
            int mid_High = mid[1];
            sort(arr, L, mid_Low - 1 );
            sort(arr, mid_Low + 1, mid_High );
        }
    }
    public int[] partition(int[] arr, int L, int R){
        int less = L - 1;
        int more = R;
        while (L < R){
            if (arr[L] < arr[R]){
                swap(arr, L++, ++less);
            }else if (arr[L] > arr[R]){
                swap(arr, --more, L++);
            }else {
                L++;
            }
        }
        swap(arr, less, R);
        return new int[] {less + 1, more};
    }
    public void swap(int []arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
