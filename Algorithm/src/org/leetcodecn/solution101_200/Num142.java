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

        System.out.println(method2(head).val);
    }

    /**
     * 不使用额外开销 ，快慢指针
     * @param head
     * @return
     */
    private static ListNode method2(ListNode head){
        if (head == null) return null;
        ListNode slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){  // 快慢指针相遇点
                while (head != slow) { // 找到环到起始节点
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
    /**
     * 利用set
     * @param head
     * @return
     */
    private static ListNode method(ListNode head) {
        if (head == null) return null;
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
