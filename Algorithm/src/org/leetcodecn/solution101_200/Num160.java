package org.leetcodecn.solution101_200;

import org.leetcodecn.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * describe: 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 例如，下面的两个链表：
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 *
 * 在节点 c1 开始相交。
 * 注意：
 *     如果两个链表没有交点，返回 null.
 *     在返回结果后，两个链表仍须保持原有的结构。
 *     可假定整个链表结构中没有循环。
 *     程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * @author alonec
 * @date 2018/09/01
 */
public class Num160 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);

        ListNode headB = new ListNode(111);
        headB.next = new ListNode(222);
        headB.next.next = new ListNode(333);
        // 公共部分
        headA.next.next = headB.next.next.next = new ListNode(7);
        headA.next.next.next = headB.next.next.next.next = new ListNode(8);

        ListNode resutlt = method2(headA, headB);
//        ListNode resutlt = getIntersectionNode(headA, headB);
        System.out.println(resutlt.val);
    }

    /**
     * 空间复杂度：O(1)
     * @param headA
     * @param headB
     * @return
     */
    private static ListNode method2(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;
        int len_A, len_B;
        len_A = len_B = 0;
        ListNode p, q;
        p = headA;
        q = headB;
        while (p != null || q != null) {
            if (p != null){
                len_A++;
                p = p.next;
            }
            if (q != null) {
                len_B++;
                q = q.next;
            }

        }
        int x = Math.abs(len_A - len_B);
        while (len_A != len_B) {
            if (len_A > len_B){
                headA = headA.next;
                len_A--;
            }else {
                headB = headB.next;
                len_B--;
            }
        }
        while (headA != headB && headA != null && headB != null){ // 找到相交点
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    /**
     * 利用Set
     * 空间复杂度： O(n)
     * @param headA
     * @param headB
     * @return
     */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> set = new HashSet<>();
        int i = 0;
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
