package org.leetcodecn.solution101_200;

import org.leetcodecn.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * describe: 141. 环形链表
 *  给定一个链表，判断链表中是否有环。
 * @author alonec
 * @date 2018/09/03
 */
public class Num141 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = head.next.next; // 指向3

        System.out.println(method2(head));
//        System.out.println(hasCycle(head));
    }

    /**
     * 不使用额外空间，利用快慢指针
     * @param head
     * @return
     */
    private static boolean method2(ListNode head){

        ListNode slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){ // 快慢指针一定会相遇
                return true;
            }
        }
        return false;
    }
    private static boolean hasCycle(ListNode head) {
        Set set = new HashSet();
        while (head != null) {
            if (set.contains(head)){ // O(1)
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
