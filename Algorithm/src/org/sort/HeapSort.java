package org.sort;

/**
 * @Auther: chenxin
 * @Date: 2018/8/10 09:06
 * @Description:
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
//        new HeapSort().maxHeapify(arr, 1, arr.length - 1);
        new HeapSort().heapSort(arr);
        for (int i: arr
             ) {
            System.out.print(i + "   ");
        }
    }
    /**
     *堆排序
     * 步骤一：对于输入的数组arr，首先进行建堆，使 A[i] >= A[left] && A[i] >= A[right]；
     * 步骤二：将根节点与最后一个节点交换位置，并将最后一个叶子剔除。再次调用方法maxHeapify使其满足堆定义；
     * 步骤三：重复步骤二，直到只剩一个节点
     */
    private void heapSort(int[] arr){
        if (arr == null && arr.length < 2)    return;
        int heap_size = arr.length - 1;  // 记录堆的最后一个元素的位置

        buildMaxHeap(arr);
        for (int i=arr.length - 1; i > 0; --i){
            swap(arr, i, 0);
            maxHeapify(arr, 0, --heap_size);
        }
    }
    /**
     *建堆（自底向上）
     * 当用数组表示存储n个元素的堆时，叶节点的下标分别是（n/2 ）, (n / 2 +1 ), ..., n
     * 那么(n /2  -1) ,(n /2  -2),...,0是根节点的下标
     */
    private void buildMaxHeap(int[] arr){
        int n = arr.length;
        for (int i = n/2 - 1; i >= 0; --i){
            maxHeapify(arr, i, arr.length - 1);
        }
    }
    private void maxHeapify(int[] arr, int i, int heap_size){
        int left = 2*i + 1;
        int right= 2*(i+1);
        int latest;
        if (left <= heap_size && arr[left] > arr[i]){
            latest = left;
        }else {
            latest = i;
        }
        if (right <= heap_size && arr[right] > arr[latest] ){
            latest = right;
        }
        if (latest != i){
            swap(arr, latest, i);
            maxHeapify(arr, latest, heap_size);
        }
    }
    private void swap(int []arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
