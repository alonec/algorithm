package org.leetcodecn.solution1_100;

import org.leetcodecn.ListNode;

/**
 * describe: 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @author alonec
 * @date 2018/09/04
 */
public class Num019 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = removeNthFromEnd(head, 4);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }
    public static ListNode method2(ListNode head, int n) {
        ListNode h = new ListNode(0); // 加个头结点，避免第一个节点被删除
        h.next = head;
        ListNode p, q;
        p = q = h;
        for (int i=0; i<n+1; i++) { // 将p先向后移动n+1个位置，即相隔n个位置（因为q要指向链表的倒数第n个节点）
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return h.next;
    }
    /**
     * 暴力法：使用两趟遍历
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int size = 0;
        int x = 0;
        ListNode cur = head;
        while (cur != null) { // 统计节点个数
            size++;
            cur = cur.next;
        }
        cur = head;
        x = size - n;
        if (x == 0){ // 移除的是首节点
            head = head.next;
        }
        if (x > 0) {
            while (x-- > 1){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
