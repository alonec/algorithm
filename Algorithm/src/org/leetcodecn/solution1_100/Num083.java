package org.leetcodecn.solution1_100;

import org.leetcodecn.ListNode;

/**
 * describe: 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * @author alonec
 * @date 2018/09/06
 */
public class Num083 {

    private static ListNode method(ListNode head) {
        ListNode cur; // cur指向当前节点
        cur = head;
        while (cur != null && cur.next != null) {
            ListNode p = cur;
            if (p.val == p.next.val) { // 利用p 跳过重复节点(如果没有重复的，则p指向当前节点，
                // 有重复，则p指向最后一个重复的节点)
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
            }
            cur.next = p.next;
            cur = cur.next;
        }
        return head;
    }
}
