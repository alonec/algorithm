package org.leftgod01.day06;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * describe: 二叉树先序、中序，后序遍历的非递归实现
 *           只需要用栈代替递归就好了，太简单了。。。
 * @author alonec
 * @date 2018/08/21
 */
class TreeNode{
    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
    }
}
public class PrintBinaryTreeWithoutRecursion {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(3);
        head.left = new TreeNode(2);
        printPre(null);
    }
    /**
     * 先序遍历
     */
    public static void printPre(TreeNode head){
        if (head == null)   return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head); // 根节点先入栈
        TreeNode e;
        while (!stack.isEmpty()){
            e = stack.pop();
            System.out.print(e.val + " ,");
            if (e.right != null){
                stack.push(e.right);
            }
            if (e.left != null){
                stack.push(e.left);
            }
        }
    }
}
