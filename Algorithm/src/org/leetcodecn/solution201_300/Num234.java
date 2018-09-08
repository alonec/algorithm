package org.leetcodecn.solution201_300;

import org.leetcodecn.ListNode;


/**
 * describe: 请判断一个链表是否为回文链表。
 *
 * @author alonec
 * @date 2018/09/07
 */
public class Num234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(1);


        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseList(slow);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    public static ListNode reverseList(ListNode head) {
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
