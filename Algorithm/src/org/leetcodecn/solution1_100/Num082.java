package org.leetcodecn.solution1_100;

import org.leetcodecn.ListNode;

/**
 * describe: 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * @author alonec
 * @date 2018/09/06
 */
public class Num082 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);

        head = method(head);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }

    private static ListNode method(ListNode head) {
        ListNode h = new ListNode(0);
        ListNode pre_cur; // cur指向当前节点
        h.next = head;
        pre_cur = h;
        while (pre_cur != null && pre_cur.next != null && pre_cur.next.next != null) {
            ListNode p = pre_cur;
            if (p.next.val == p.next.next.val) {
                while (p.next.next != null && p.next.val == p.next.next.val ) {
                    p = p.next;
                }
                pre_cur.next = p.next.next;

            }else {
                pre_cur = pre_cur.next; // 当下一个数不是重复的数时，再将pre_cur移动
            }
        }
        return h.next; // 第一个数也可能是重复的
    }
}
