package org.jzoffer;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 思路：左<根<右（前提是左不空/右不空）
 *      1. 先根据后续遍历得到根节点（最后一个元素就是根）
 *      2. 得到左右子树
 *      3. 递归检查左子树是否满足条件（左<根<右），满足，则进行下一步
 *      4. 先检查右子树：
 *          4.1 先检查是不是都大于根，满足，进行下一步
 *          4.2 再递归右子树
 *      5. 上述步骤都满足，则返回真，否则返回假
 *
 */
public class Number_23 {
    public static void main(String[] args) {
        //int a[] = {4,8,6,12,16,14,10};
        int a[] = {};
        System.out.println(new Number_23().VerifySquenceOfBST(a));
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null ||  sequence.length == 0){
            return false;
        }
        return judge(sequence, 0, sequence.length-1);
    }
    public boolean judge(int []a, int l, int r){
        if (l==r){
            return true;
        }
        boolean result = true;

        int root = a[r]; // 根节点
        int i=0;
        while (a[i] < root && i<r)  i++;  // 移动到右子树的起点的下标位置
        int mid = i;
        if(i > l){ // 左不空
            result = judge(a, l, i-1);   // 继续检查整个左子树是否符合二叉搜索树的定义
        }
        if(r > i && result){  // 右不空,且左子树已经满足条件
            while (a[i] > root && i<r) i++;  //检查右子树是否都大于根
            if (i != r) {
                result =  false;
            }else {
                result = judge(a, mid, r-1);   // 继续检查整个右子树是否符合二叉搜索树的定义
            }
        }
        return result;
    }
}
