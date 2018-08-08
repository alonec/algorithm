package org.sort;

import java.util.Random;

/**
 * 1.分解，以最后一个元素为基准，将数组分成两个数组，比基准大的放前面，小于等于的放后面
 * 2.合并，对于两个已经排好序的数组来说，左数组所有元素都是大于右数组的
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {6, 3, 8, 2, 1, 10, 5};
        sort(a, 0, 6);
        for (int i : a
                ) {
            System.out.println(i);
        }
    }

    /**
     * 传入一个数组，返回分解后基准在数组中的下标 i
     *
     * @param 数组：a[low, high](其中low和high都是数组下标)
     * @return i
     */
    public static int divide(int[] a, int low, int high) {
        /*if(high - low == 1){    // 只有一个元素，不必分解
            return 0;
        }*/
        /*Random random = new Random();
        int index = random.nextInt(high - low);
        System.out.println("index:" + index);*/
        int tag = a[low];  // 以最后一个元素为基准
       /* int i = low, j;
        for (j = low; j < high; ++j) {  // 遍历数组
            if (a[j] <= tag) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;        // i向后移动
            }
        }
        int temp = a[i];
        a[i] = a[high];
        a[high] = temp;
        return i;*/
        int i = low - 1, j;
        for (j = low; j < high; ++j) {  // 遍历数组
            if (a[j] <= tag) {
                i++;        // i向后移动
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
        return i + 1;
    }

    public static void sort(int[] a, int low, int high) {
        if (high > low) {
            int mid = divide(a, low, high);
            sort(a, low, mid - 1); // 对前半段数组排序
            sort(a, mid + 1, high);  // 对后半段数组排序
        }
    }
}
