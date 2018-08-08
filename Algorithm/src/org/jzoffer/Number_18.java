package org.jzoffer;

/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路：1. 广度优先遍历。对于每个非叶子节点，交换其左右子树
 */
public class Number_18 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        node1.left = new TreeNode(5);
        node1.right = new TreeNode(7);
        TreeNode node2 = new TreeNode(10);
        node2.left = new TreeNode(9);
        node2.right = new TreeNode(11);
        TreeNode root = new TreeNode(8);
        root.left = node1;
        root.right = node2;

        new Number_18().Mirror(null);

    }
    public void Mirror(TreeNode root) {
        if(root != null){       // 必须进行非空判断，才能入队列
            Queue<TreeNode> queue = new LinkedList<TreeNode>();

            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode e = queue.poll();
                if(e.left != null || e.right != null){ // 对于只有左子树/右子树，也是满足的。
                    TreeNode temp = e.left;
                    e.left = e.right;
                    e.right = temp;
                }
                if(e.left != null){
                    queue.offer(e.left);
                }
                if (e.right != null){
                    queue.offer(e.right);
                }
            }
        }
    }

}
