package org.leetcodecn.solution401_500;

import org.leetcodecn.ListNode;

/**
 * describe: 两数相加 II
 *   最高为为链表开始位置
 * @author alonec
 * @date 2018/09/08
 */
public class Num445 {

    /**
     * 不翻转链表 //// 未AC
     * @return
     */
    private ListNode method(ListNode l1, ListNode l2){

        return null;
    }

    /**
     * 利用翻转链表来实现
     * @param l1
     * @param l2
     * @return
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode head = new ListNode(0);
        ListNode h = head;
        int carry = 0;
        while (l1 != null || l2 != null){
            int y;
            int x;
            x = l1 != null ? l1.val: 0;
            y = l2 != null ? l2.val: 0;
            int sum = x + y + carry;
            carry = sum / 10;
            h.next = new ListNode(sum % 10);
            h = h.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry == 1){
            h.next = new ListNode(1);
        }
        return reverse(head.next);
    }
    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = new ListNode(0);// 临时的头节点
        while (head != null) { // 头插法
            ListNode e = head;
            head = head.next;
            e.next = h.next;
            h.next = e;
        }
        return h.next;
    }
}
