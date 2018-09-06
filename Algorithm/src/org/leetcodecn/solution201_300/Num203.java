package org.leetcodecn.solution201_300;

import org.leetcodecn.ListNode;

/**
 * describe:删除链表中等于给定值 val 的所有节点。
 *
 * @author alonec
 * @date 2018/09/06
 */
public class Num203 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(2);

        head = removeElements(head, 1);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }
    public static ListNode removeElements(ListNode head, int val) {

        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val) {
                pre.next = cur.next;
            }else {
                pre = cur; // 指向下一个元素（没被删除的）
            }
            cur = cur.next;
        }
        return h.next;
    }
}
