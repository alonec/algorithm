package com.baidu.offer180530;

public class CountingSort {
	/*
	 * input：A[1..n], 每个A[i]是在1到k范围的整数
	 * output: B[1..n]
	 * 辅助存储序列：C[1..k]
	 * 
	 *总结： 如果 k < nlgn,就用计数排序，因为此时运行时间是线性的。
	 *		否则用 归并排序。
	 */
	public static int [] solution(int[] A, int[]B, int k) {
		
		int n = A.length;
		int[] C = new int[k];
		
		// 将数组C的所有元素置零
		for(int i=0; i<k; ++i) {
			C[i] = 0;
		}
		// 计数。如果一个输入为i， 就将C[i]的值加1
		for(int j=0; j<n; ++j)
			C[A[j]] = C[A[j]] + 1;
		// 通过加总算，确定对每一个i = 0,1,...,k,有多少输入元素是小于等于i的。
		for(int i=1; i<k; ++i)
			C[i] = C[i] + C[i-1];
		
		// 把每个元素放到它在输出数组B的正确位置上。
		// 如果所有n个元素都是互异的，那么对于每一个A[i]来说，C[A[i]]-1 (注意是减1，因为下标从0开始)就是在输出数组B中的正确位置，
		// 这是因为共有C[A[i]]个元素小于等于A[i]。
		// 因为所有的元素不可能都是互异的，所以在将每一个值A[i]放入数组B中后，都要将C[A[i]]的值减1.
		for(int j=n-1; j>=0; --j) {
			B[C[A[j]] - 1] = A[j];
			C[A[j]] = C[A[j]] - 1;
		}
		return null;
	}
	public static void main(String[] args) {
		int[] A = {4,1,3,4,3};
		int[] B = new int[5];
		int k = 5;
		
		solution(A,B,k);
		for(int i=0; i<5; ++i)
			System.out.println(B[i]);
	}
}
