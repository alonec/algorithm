package org.leetcodecn.solution201_300;

import org.leetcodecn.ListNode;

/**
 * describe: 206. 反转链表
 *  反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author alonec
 * @date 2018/09/01
 */
public class Num206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = method2(head);
//        head = method1(head);
        while (head != null){
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }
    /**
     * 递归法
     * 我遇到的我问题是，怎么保存反转后的首节点。最后解决：每次都是将反转后的新链表首节点返回
     */
    private static ListNode method2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode nextListNode = head.next;
        head.next = null;
        ListNode reverseHead = method2(nextListNode);
        nextListNode.next = head; // 将当前节点反转
        return reverseHead; // 反转后的首节点
    }
    /**
     * 迭代法
     * @param head
     * @return
     */
    private static ListNode method1(ListNode head) {
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
