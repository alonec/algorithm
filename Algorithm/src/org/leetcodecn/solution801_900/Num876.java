package org.leetcodecn.solution801_900;

import org.leetcodecn.ListNode;

/**
 * describe: 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 * 提示：
 *     给定链表的结点数介于 1 和 100 之间。
 *
 * @author alonec
 * @date 2018/09/06
 */
public class Num876 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        head = method(head);
        System.out.print(head.val + "  ");
    }
    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static ListNode method(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
