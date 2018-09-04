package org.leetcodecn.solution1_100;

import org.leetcodecn.ListNode;

/**
 * describe: 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。（稳定）
 * @author alonec
 * @date 2018/09/04
 */
public class Num086 {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(9);

        head = partition(head, 4);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }

    /**
     * 此题并不要求等于x的数放中间
     * @param head
     * @param x
     * @return
     */
    private static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode less_head = new ListNode(0);
        ListNode more_head = new ListNode(0);
        ListNode less_cur, more_cur;
        less_cur = less_head;
        more_cur = more_head;
        while (head != null) {
            if (head.val < x) {
                less_cur.next = head;
                less_cur = head;
            }else{
                more_cur.next = head;
                more_cur = head;
            }
            head = head.next;
        }
        more_cur.next = null;
        less_cur.next = more_head.next;
        return less_head.next;
    }
}
