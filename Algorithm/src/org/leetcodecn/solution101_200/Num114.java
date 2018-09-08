package org.leetcodecn.solution101_200;

import org.leetcodecn.ListNode;
import org.leetcodecn.TreeNode;

import java.util.LinkedList;
import java.util.Stack;


/**
 * describe:
 *
 * @author alonec
 * @date 2018/09/07
 */
public class Num114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
//        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(3);

        flatten(root);
        while (root != null) {
            System.out.print(root.val + "  ");
            root = root.right;
        }
    }

    /**
     * 非递归
     * @param root
     */
    private static void flatten(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                flatten(root.left);
                TreeNode cur = root.left;
                while (cur.right != null) {
                    cur = cur.right;
                }
                cur.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            if (root.right != null) {
                flatten(root.right);
            }
        }
    }
}

