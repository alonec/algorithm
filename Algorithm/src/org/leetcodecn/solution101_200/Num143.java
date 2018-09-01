package org.leetcodecn.solution101_200;


import org.leetcodecn.ListNode;

/** Sort a linked list in O(n log n) time using constant space complexity.
 * 题意：对一个链表进行排序，要求时间复杂度不超过O(n log n)
 *
 * 归并排序
 */
public class Num143 {
    public static void main(String[] args) {

        ListNode head = new ListNode(7);
        ListNode h = head;
        int arr[] ={2,4,1,8,5,3,10,6};
        for(int i=0; i<8; ++i){
            h.next = new ListNode(arr[i]);
            h = h.next;
        }

        ListNode p = sortList(head);
        while (p != null){
            System.out.print(p.val);
            p = p.next;
        }
    }
    public static ListNode sortList(ListNode head) {    // 注意这里是不带头结点（坑）
        if(head == null || head.next == null){
            return head;
        }
        ListNode tem = getMid(head);
        ListNode mid;
        mid = tem.next; // 得到的是右子链表的开始节点
        tem.next = null;

        return merge(sortList(head),sortList(mid)); // 注意，head.next，mid是不带头结点的链表

    }
    public static ListNode getMid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        // 统计节点数
        ListNode slow,quick;
        slow = quick = head;
        while(quick.next != null && quick.next.next != null){ // 至少有两个节点才分解，这里是我开始使用的方法的误区
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
    public static ListNode merge(ListNode left,ListNode right){
        ListNode p, q;
        p = new ListNode(0);
        q = p;
        while (left != null && right != null){
            if(left.val<right.val){
                p.next = left;
                left= left.next;
            }else {
                p.next =right;
                right = right.next;
            }
            p = p.next;
        }
        if(left != null) p.next= left;
        if(right!= null) p.next= right;

        return q.next;
    }

}