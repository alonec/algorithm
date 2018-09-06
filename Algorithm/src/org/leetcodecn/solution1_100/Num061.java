package org.leetcodecn.solution1_100;

import org.leetcodecn.ListNode;

/**
 * describe: 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * @author alonec
 * @date 2018/09/06
 */
public class Num061 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        head = method(head, 2);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }
    private static ListNode method(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        int size = 1;
        ListNode old_tail; // 指向原链表尾部
        old_tail = head;
        while (old_tail.next != null) { // 统计节点个数.
            size++;
            old_tail = old_tail.next;
        }
        k = k % size;
        if (k == 0) return head; // k如果是size的整数倍，则代表不用翻转
        ListNode h = new ListNode(0);
        ListNode p, q;
        p = q = h;
        h.next = head;
        while (k-- > 0) { // p移动到第k个节点
            p = p.next;
        }
        while (p.next != null) { // 将q指向倒数第k+1个数
           p = p.next;
            q = q.next;
        }
        old_tail.next = head;
        ListNode new_head = q.next;
        q.next = null;
        return new_head;
    }
}
