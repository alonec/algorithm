package org.leftgod01.day03;

/**
 * @Auther: chenxin
 * @Date: 2018/8/7 01:56
 * @Description: 快排的优化——>荷兰国旗问题
 */
public class QuickSort_02 {

    // [...3,4,5,0,6,4...]
    public static void main(String[] args) {
        int[] a = {6, 3, 8, 6, 1, 6, 5};
        new QuickSort_01().quicksort01(a, 0, 6);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
    public void sort(int arr[], int L, int R){
        if (arr == null || arr.length < 1) return;
        int[] mid = partition(arr, L, R);
        int mid_Low = mid[0];
        int mid_High = mid[1];

        sort(arr, L, mid_Low - 1 );
        sort(arr, mid_Low + 1, mid_High );
    }
    public int[] partition(int [] arr, int L, int R){
        int less = L - 1;
        int more = R;
        while ( L < R){     // 因为当等于基准时，不会交换。必须在循环外面将基准与大于区内最左边的数交换。所以不遍历到最后了，
            if (arr[L] < arr[R]){   // cur < 基准  ： 小于区右移
                swap(arr,++less, L++);
            }else if (arr[L] > arr[R]){
                swap(arr, L++, --more); // cur > 基准：将当前cur与大于区的左边值交换
            }else {
                L++;    // cur == 基准：less不变
            }
        }
        swap(arr, more, R);  // 将最后的基准值，与大于区的最左面（大于区内的）的值交换
        return new int[] {less + 1, more};
    }
    public void swap(int []arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
