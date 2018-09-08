package org.leetcodecn.solution201_300;

import org.leetcodecn.ListNode;
/**
 * describe: 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *
 *  4 -> 5 -> 1 -> 9
 *
 链表至少包含两个节点。
 链表中所有节点的值都是唯一的。
 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 不要从你的函数中返回任何结果。
 * @author alonec
 * @date 2018/09/07
 */
public class Num237 {
    public void deleteNode(ListNode node) {
        // 将node变为的后继节点，然后将node的后继节点删除（题意要求可以这样做：删除除尾节点以外的节点）。
        // 这样可以省去找node的前驱节点的操作
        node.val = node.next.val;
        node.next = node.next.next;
    }
}