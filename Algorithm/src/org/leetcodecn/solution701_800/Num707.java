package org.leetcodecn.solution701_800;

import org.leetcodecn.ListNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

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

        t.addAtIndex(1,2);
        t.addAtIndex(0,1);

        ListNode head = t.linkedList;
        System.out.println(t.get(0));
        System.out.println(t.get(1));
        /*while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }*/
    }
    public ListNode linkedList;
    /** Initialize your data structure here. */
    Num707() {
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    int get(int index) {
        int i = 0;
        ListNode head = linkedList;
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
        head.next = linkedList;
        linkedList = head;
    }
    /** Append a node of value val to the last element of the linked list. */
    void addAtTail(int val) {
        ListNode head = linkedList;
        ListNode node = new ListNode(val);
        if (head != null) {
            while (head.next != null) {
                head = head.next;
            }
            head.next =  node;
        }else {  // 链表是空的
            linkedList = node;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    void addAtIndex(int index, int val) {
        ListNode node = new ListNode(val);
        if (linkedList != null) {
            if (index == 0) {
                node.next = linkedList;
                linkedList = node;
            }else {
                int i = 0;
                ListNode head = linkedList;
                if (head != null && index==0) {
                    linkedList = node;
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
        }else {
            linkedList = node;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    void deleteAtIndex(int index) {
        if (linkedList != null) {
            if (index == 0) {
                linkedList = linkedList.next;
            }else {
                ListNode head = linkedList;
                int i = 0;
                while (head  != null && i<index - 1) {
                    head = head.next;
                    i++;
                }
                if (head == null) return;
                if (head.next == null && index == 0) {//只有一个节点的情况
                    linkedList = null;
                    return;
                }
                if (head.next != null) {
                    ListNode tmp = head.next;
                    head.next = tmp.next;
                }
            }
        }
    }
}
