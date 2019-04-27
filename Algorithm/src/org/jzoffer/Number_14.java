package org.jzoffer;

import org.leetcodecn.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Number_14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(k <1 ){    // if k<1,代表链表没有该节点，则返回null
            return null;
        }

        int n = 0;
        ListNode h = head;
        while(h != null){
            h = h.next;
            n++;
        }
        n = n - k+1;
        if(n <= 0 ){    // if k>=n,代表链表没有该节点，则返回null
            return null;
        }
        while(--n>0 && head!= null){  // if k < n(包括了k<=0)
            head = head.next;
        }
        return head;

    }


}
