package org.leetcodecn.solution101_200;

import org.leetcodecn.ListNode;

/**
 * describe: 对链表进行插入排序
 *
 * @author alonec
 * @date 2018/09/08
 */
public class Num147 {
    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(8);

        head = insertionSortList(head);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode modify_head = insertionSortList(head.next); // 递归
        head.next = modify_head; // head.next重新挂链
        ListNode p = new ListNode(0);
        p.next = modify_head;  // p 是已经排序好的链表的头结点
        ListNode h = new ListNode(0);
        h.next = head;  // 当前链表的头结点
        while (p.next != null && p.next.val < head.val) { // p指向modify_head后第一个大于head的节点的前面
            p = p.next;
        }
        // 插入
        if (modify_head != null && p.next != modify_head) {
            h.next = modify_head;
            head.next = p.next;
            p.next = head;
        }
        return h.next;
    }
}
