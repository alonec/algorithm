package org.jzoffer;

import java.util.*;
/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 理解题意：子树的意思是包含了一个节点，就得包含这个节点下的所有节点
 * 子结构的意思是只要一部分相同就可以了
 */
/**
 * 1.有一个树为空，则返回false
 * 2.遍历root1，找到第一个与root2相对于的根节点（广义优先，按行遍历）
 * 3.找到root1对应的root2根节点后，在进行匹配，如果不匹配，重复步骤2
 * 4.root1遍历完，结束
 */
public class Number_17 {
    /**
     *      8               8
     *    /   \           /   \
     *   8     9         2     7
     *  /\    /  \
     * 2  7   3   5
     */
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(8);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(7);
        TreeNode node2 = new TreeNode(9);
        node2.left = new TreeNode(3);
        node2.right = new TreeNode(5);
        TreeNode root1 = new TreeNode(8);
        root1.left = node1;
        root1.right = node2;

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(5);

        boolean result = new Number_17().HasSubtree(root1,root2);
        System.out.println(result);


    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        int cnt = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root1);
        while( ! queue.isEmpty()){
            TreeNode e = queue.poll();// 从队列中取出元素
            if(e.val == root2.val) { //找到root1对应的root2根节点后,进行匹配
                TreeNode p = e;
                TreeNode q = root2;
                Queue<TreeNode> queue1 = new LinkedList();
                queue1.offer(p);
                Queue<TreeNode> queue2 = new LinkedList();
                queue2.offer(q);
                cnt = 0;
                while(! queue1.isEmpty() && ! queue2.isEmpty()){
                    p = queue1.poll();
                    q = queue2.poll();

                    if( p.val != q.val){    // 不一致，则直接跳出循环
                        cnt = 1;
                        break;
                    }
                    if(p.left != null){
                        queue1.offer(p.left);
                    }
                    if(p.right != null){
                        queue1.offer(p.right);
                    }
                    if(q.left != null){
                        queue2.offer(q.left);
                    }
                    if(q.right != null){
                        queue2.offer(q.right);
                    }
                }
                if( cnt != 1 && queue2.isEmpty()){   // 所有元素一一对应，全部符合
                    return true;
                }
            }
            if(e.left != null){
                queue.offer(e.left);
            }
            if(e.right != null){
                queue.offer(e.right);
            }
        }
        return false;
    }
}
