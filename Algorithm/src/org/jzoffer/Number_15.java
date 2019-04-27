package org.jzoffer;

import org.leetcodecn.ListNode;

import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */

/*class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

/**
 * 利用栈的先进先出，来实现链表反转
 */
public class Number_15 {
    public static void main(String[] args) {
        int []arr = {5,4,3,2,1};
        ListNode head = new ListNode(5);
        ListNode h = head;
        for(int i=1; i<5; ++i){
            h.next = new ListNode(arr[i]);
            h = h.next;
        }
        head = new Number_15().ReverseList(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode h = head;
        while (!stack.empty()){
            head.next = stack.pop();
            head = head.next;
        }
        head.next =null; // 将尾部元素置空，否则会出现最后两个元素相互引用
        return h;
    }
}
