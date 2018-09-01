package org.leetcodecn.solution1_100;

import org.leetcodecn.ListNode;

import java.util.List;

/**
 * describe: 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @author alonec
 * @date 2018/09/01
 */
public class Num092 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

//        head = reverseBetween(head, 1, 3);
//        head = reverseBetween(head, 1, 4);
//        head = reverseBetween(head, 2, 2);
//        head = reverseBetween(head, 2, 4);
// head = method2(head, 1, 3);
//        head = method2(head, 1, 4);
//        head = method2(head, 2, 2);
        head = method2(head, 2, 4);
        while (head != null){
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }

    /**
     * 不用额外空间，更优
     * @param head
     * @param m
     * @param n
     * @return
     */
    private static ListNode method2(ListNode head, int m, int n) {
        if (head == null || head.next == null || m < 1){
            return head;
        }
        int len = n - m + 1;
        ListNode pre_head; // 初始化开始逆置的节点的前置节点
        pre_head = null;
        ListNode modify_list_tail; // 记录逆置后的链表部分的尾节点(即开始逆置的节点)
        modify_list_tail = head;
        while (modify_list_tail != null && m-- > 1) {
            pre_head = modify_list_tail;
            modify_list_tail = modify_list_tail.next;
        }
        ListNode newHead, cur;
        newHead = null;
        cur = modify_list_tail;
        while (cur != null && len-- > 0){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        modify_list_tail.next = cur;
        if (pre_head == null){
            head = newHead;
        }else {
            pre_head.next = newHead; // 逆置的开始节点不是从1位置开始
        }
        return head;
    }

    /**
     * 自己的思路解，用了额外的一个空间
     * @param head
     * @param m
     * @param n
     * @return
     */
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) return head;
        if (m < 1) m = 1; // 输入的m小于1， 则将其置为1
        ListNode p, q,  h; // h 是临时的头节点， p 用来记录第m个节点的前一个节点， q记录m节点
        h = new ListNode(0);
        h.next = head;
        ListNode cur = h;
        int i = 1;
        for (; i<m && cur != null; i++) {
            cur = cur.next;
        }
        p = cur;
        q = cur = cur.next;
        for (; i<=n && cur != null; i++){
            ListNode e = cur;
            cur = cur.next;
            e.next = p.next;
            p.next = e;
        }
        q.next = cur;
        return h.next;
    }
}
