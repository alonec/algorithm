package org.leetcodecn.solution1_100;

import org.leetcodecn.ListNode;

/**
 * describe: 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * @author alonec
 * @date 2018/09/05
 */
public class Num024 {
    /**
     * 两指针联动，用头结点
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {

        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p, q;
        p = h;
        q = head;
        while (q != null && q.next != null) { // 两两交换
            p.next = q.next;
            q.next = q.next.next;
            p.next.next = q;

            if (q.next != null && q.next.next != null){
                p = q;
                q = q.next;
            }else {
                return h.next;
            }
        }
        return h.next;
    }
}
