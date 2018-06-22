package com.baidu.offer180530;

public class CountingSort {
	/*
	 * input��A[1..n], ÿ��A[i]����1��k��Χ������
	 * output: B[1..n]
	 * �����洢���У�C[1..k]
	 * 
	 *�ܽ᣺ ��� k < nlgn,���ü���������Ϊ��ʱ����ʱ�������Եġ�
	 *		������ �鲢����
	 */
	public static int [] solution(int[] A, int[]B, int k) {
		
		int n = A.length;
		int[] C = new int[k];
		
		// ������C������Ԫ������
		for(int i=0; i<k; ++i) {
			C[i] = 0;
		}
		// ���������һ������Ϊi�� �ͽ�C[i]��ֵ��1
		for(int j=0; j<n; ++j)
			C[A[j]] = C[A[j]] + 1;
		// ͨ�������㣬ȷ����ÿһ��i = 0,1,...,k,�ж�������Ԫ����С�ڵ���i�ġ�
		for(int i=1; i<k; ++i)
			C[i] = C[i] + C[i-1];
		
		// ��ÿ��Ԫ�طŵ������������B����ȷλ���ϡ�
		// �������n��Ԫ�ض��ǻ���ģ���ô����ÿһ��A[i]��˵��C[A[i]]-1 (ע���Ǽ�1����Ϊ�±��0��ʼ)�������������B�е���ȷλ�ã�
		// ������Ϊ����C[A[i]]��Ԫ��С�ڵ���A[i]��
		// ��Ϊ���е�Ԫ�ز����ܶ��ǻ���ģ������ڽ�ÿһ��ֵA[i]��������B�к󣬶�Ҫ��C[A[i]]��ֵ��1.
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
