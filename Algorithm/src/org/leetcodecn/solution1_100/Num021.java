package org.leetcodecn.solution1_100;

import org.leetcodecn.ListNode;

/**
 * describe: 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author alonec
 * @date 2018/09/03
 */
public class Num021 {
    private static ListNode method(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode h = new ListNode(0);
        ListNode cur = h;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next =  l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null){
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return h.next;
    }
}
