package org.jzoffer;

import java.util.ArrayList;
import java.util.Stack;
/*     	    8
*     	   /  \
*     	  6   10
*     	 / \  / \
*     	5  7 9   11
*/
public class Number_24 {
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

        new Number_24().FindPath(root, 27);
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        stack.push(root);

        TreeNode p = null;
        while (!stack.isEmpty()){
            p = stack.pop();
            System.out.println(p.val);
            if (p.right != null)    stack.push(p.right);
            if (p.left != null)    stack.push(p.left);
        }
        return null;
    }
}
