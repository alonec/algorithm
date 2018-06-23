/*
 * 问题描述：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * 方法一：运行时间：1355 ms  占用空间：9376K
 * 方法二：运行时间：21 ms 	 占用内存：9232K
 * 方法三：运行时间：21 ms 	 占用空间：9384K
 */
public class Fibona{
    /*
    * 方法一: 朴素算法
    * 时间复杂度： 指数
    */
    /*public int Fibonacci(int n) {
         if(n<0)        // 输入不合法
             return -1; 
         else if(n==0)
             return 0;
         else if(n==1)
             return 1;
         else            // n>=2
             return Fibonacci(n-1) + Fibonacci(n-2);
    }*/
     /*
    * 方法二：自下而上的解决方法
    * 时间复杂度： O(n)
    */
    /*public int Fibonacci(int n) {
        int f = -1;
        if(n==0)
            f = 0;
        else if(n==1)
            f = 1;
        else {
            int f1 = 0, f2 = 1;
            for(int i=2; i<=n; ++i){
                f = f1 + f2;
                f1 = f2;
                f2 = f;
            }
        }
        
        return f;
    }*/
	/*
	 * 方法三：平方递归算法((Fn+1, Fn), (Fn, Fn-1)) = ((1,1),(1,0))^n,
	 * 		 用该公式配合以平方递归，将运行时间降到了lgn.
	 * 		看该算法之前，应该先看乘方问题（求x^n）。
	 * 时间复杂度： O(lgn)
	 */
    public int Fibonacci(int n) {
        int A[][] = {{0,0},{0,0}}; // 辅助数组，保存计算后的((Fn+1, Fn), (Fn, Fn-1))结果
        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        else{
            A = conquer(n); 
            return A[0][1];
        }
    }
    public int[][] conquer(int n){
        int A[][] = {{1,1},{1,0}};
        int B[][] = {{0,0},{0,0}};
        if(n==1){	// n=1时，就是矩阵((1,1),(1,0))
            return A;
        }else{		// 递归：分解合并（divide and conquer）
            B = conquer(n/2); // 这里其实是应该放在if 或 else里面的，但是由于是公共的代码，所以提了出来
            if(n%2==0){    // if  n是偶数
                A[0][0] = B[0][0]*B[0][0] + B[0][1]*B[1][0];
                A[1][0] = B[1][0]*B[0][0] + B[1][1]*B[1][0];
                A[0][1] = B[0][0]*B[0][1] + B[0][1]*B[1][1];
                A[1][1] = B[1][0]*B[0][1] + B[1][1]*B[1][1];
                return A;
            }else{         // if   n是奇数。奇数相比偶数，其实就是提出来了一个矩阵((1,1),(1,0))。
            	A[0][0] = B[0][0]*B[0][0] + B[0][1]*B[1][0];
                A[1][0] = B[1][0]*B[0][0] + B[1][1]*B[1][0];
                A[0][1] = B[0][0]*B[0][1] + B[0][1]*B[1][1];
                A[1][1] = B[1][0]*B[0][1] + B[1][1]*B[1][1];
                B[0][0] = A[0][0] + A[0][1];
                B[0][1] = A[0][0];
                B[1][0] = A[1][0] + A[1][1];
                B[1][1] = A[1][0];
                return B;
            }
            
        }
    }
}











