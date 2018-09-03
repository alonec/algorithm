package org.leetcodecn.solution101_200;

import org.leetcodecn.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * describe: 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 说明：不允许修改给定的链表。
 * @author alonec
 * @date 2018/09/03
 */
public class Num142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next; // 指向2

        System.out.println(method1(head).val);
    }
    private static ListNode method1(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){  // 快慢指针一定会相遇
                return slow;
            }
        }
        return null;
    }
    /**
     * 使用了额外的空间开销
     */
    private static ListNode method(ListNode head) {
        Set set = new HashSet();
        while (head != null) {
            if (set.contains(head)){ // O(1)
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

}
