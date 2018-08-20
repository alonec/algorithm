package org.leetcodecn.day01;

import org.leetcodecn.ListNode;

/**
import org.leetcodecn.ListNode;

/**
 *describe: 2. 两数之和
 *给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。
 * 将两数相加返回一个新的链表。
 *@author alonec
 *@date 2018/08/20
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
//        [2,4,3]
//[5,6,4]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(9);
        ListNode h = add(l1, l2);
        while (h!=null){
            System.out.println(h.val + "  ,");
            h = h.next;
        }
    }
    public static ListNode add(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode h = head;
        int carry = 0;
        while (l1 != null || l2 != null){
            int x;
            int y;
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
        return head.next;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) { // 两链表都非空
        ListNode head = new ListNode(0);
        ListNode h = head;
        int addHigh = 0;
        while (l1 != null || l2 != null){
            int val = l1.val + l2.val;
            if (addHigh == 1){
                val += 1;
                addHigh = 0; // 将进位置零
            }
            if (val > 9){
                h.next = new ListNode(val - 10);
                addHigh = 1;
            }else{
                h.next = new ListNode(val);
            }
            h = h.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int val = l1.val;
            if (addHigh == 1){
                val += 1;
                addHigh = 0; // 将进位置零
            }
            if (val > 9){
                h.next = new ListNode(val - 10);
                addHigh = 1;
            }else{
                h.next = new ListNode(val);
            }
            h = h.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int val = l2.val;
            if (addHigh == 1){
                val += 1;
                addHigh = 0; // 将进位置零
            }
            if (val > 9){
                h.next = new ListNode(val - 10);
                addHigh = 1;
            }else{
                h.next = new ListNode(val);
            }
            h = h.next;
            l2 = l2.next;
        }
        if (addHigh == 1){
            h.next = new ListNode(1);
        }
        return head.next;
    }
}
