package org.jzoffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

import org.leetcodecn.ListNode;

/**
 * 时间复杂度：O(n+m)
 * 空间复杂度：O(1)
 */
public class Number_16 {
    public static void main(String[] args) {
        int []arr = {1,3,5,7,9};
        ListNode head1 = new ListNode(arr[0]);
        ListNode h = head1;
        for(int i=1; i<5; ++i){
            h.next = new ListNode(arr[i]);
            h = h.next;
        }
        int []brr = {2,4,6,8,10};
        ListNode head2 = new ListNode(brr[0]);
        h = head2;
        for(int i=1; i<5; ++i){
            h.next = new ListNode(brr[i]);
            h = h.next;
        }
        head1 = new Number_16().Merge(head1,head2);
        while (head1 != null){
            System.out.println(head1.val);
            head1 = head1.next;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null ){
            return list2;
        }
        if(list2 == null){      // list1不为null，list2为null，返回list1
            return list1;
        }
        // 下面都是list1，list2不为null的情况下进行的
        ListNode head = new ListNode(0);
        ListNode h = head;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                head.next = list1;
                list1 = list1.next;
            }else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if(list1 != null){
            head.next = list1;
        }
        if (list2 != null){
            head.next = list2;
        }

        return h.next;
    }

}
