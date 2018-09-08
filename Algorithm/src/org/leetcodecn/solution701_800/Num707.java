package org.leetcodecn.solution701_800;

import org.leetcodecn.ListNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import javax.print.attribute.standard.NumberUp;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * describe:  设计链表
 * 在链表类中实现这些功能：
 *
 *     get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 *     addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 *     addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 *     addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 *     deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * @author alonec
 * @date 2018/09/06
 */
public class  Num707{
    public static void main(String[] args) {
        Num707 t = new Num707();
        /*ListNode LinkedList = new ListNode(1);
        LinkedList.next = new ListNode(2);
        LinkedList.next.next = new ListNode(3);*/
        t.addAtHead(1);
        t.addAtTail(3);
        t.addAtIndex(1,2);
        System.out.println(t.get(1));
        t.deleteAtIndex(1);
        System.out.println(t.get(1));
    }
    private ListNode LinkedList;
    /** Initialize your data structure here. */
    Num707() {
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    int get(int index) {
        int i = 0;
        ListNode head = LinkedList;
        while (head != null && i<index) {
            head = head.next;
            i++;
        }
        if (head != null && i == index) return head.val;
        else return -1;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    void addAtHead(int val) {
        ListNode head = new ListNode(val);
        head.next = LinkedList;
        LinkedList = head;
    }
    /** Append a node of value val to the last element of the linked list. */
    void addAtTail(int val) {
        ListNode head = LinkedList;
        ListNode node = new ListNode(val);
        if (head != null) {
            while (head.next != null) {
                head = head.next;
            }
            head.next =  node;
        }else {  // 链表是空的
            LinkedList = node;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    void addAtIndex(int index, int val) {
        int i = 0;
        ListNode node = new ListNode(val);
        ListNode head = LinkedList;
        if (head != null && index==0) {
            LinkedList = node;
            return;
        }
        while (head != null && i<index - 1) {
            head = head.next;
            i++;
        }
        if (head != null && head.next == null) {
            head.next = node;
        }
        else if (i == index - 1 && head != null && head.next != null) {
            node.next = head.next;
            head.next = node;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    void deleteAtIndex(int index) {
        ListNode head = LinkedList;
        int i = 0;
        while (head  != null && i<index - 1) {
            head = head.next;
            i++;
        }
        if (head == null) return;
        if (head.next == null && index == 0) {//只有一个节点的情况
            LinkedList = null;
            return;
        }
        if (head.next != null) {
            ListNode tmp = head.next;
            head.next = tmp.next;
        }
    }
}
