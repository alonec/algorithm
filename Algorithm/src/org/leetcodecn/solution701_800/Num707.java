package org.leetcodecn.solution701_800;

import org.leetcodecn.ListNode;

import java.lang.management.LockInfo;

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
public class Num707{
    public static void main(String[] args) {
        Test t = new Test();
        t.addAtHead(1);
        t.addAtTail(3);
        t.addAtIndex(1,2);
////        System.out.println(t.get(1));
        t.deleteAtIndex(1);
        while (t.head != null) {
            System.out.println(t.head.val);
            t.head = t.head.next;
        }
////        System.out.println(t.get(1));
    }
}

class Test {
    public ListNode head;
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     *  0-index
     * */
    public int get(int index) {
        if (index < 0 || head == null) {
            return -1;
        }
        ListNode cur = head;
        while (cur != null && index-- > 0) {
            cur = cur.next;
        }
        return cur == null ? -1 : cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode h = new ListNode(val);
        h.next = head;
        head = h;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null){
            head = new ListNode(val);
        }else {
            ListNode cur = head;
            while (cur.next != null) { // cur移动到尾节点
                cur = cur.next;
            }
            cur.next = new ListNode(val);
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode e = new ListNode(val);
        if (head == null){
            head = e;
        }else {
            ListNode h = new ListNode(0);
            h.next = head;
            ListNode cur = h;
            while (cur.next != null && index-- > 0) {
                cur = cur.next;
            }
            if (cur.next == null){
                cur.next = e;
            } else {
                e.next = cur.next;
                cur.next = e;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = h;
        while (cur.next != null && index-- > 0){
            cur = cur.next;
        }
        if (cur.next != null && cur.next.next != null) {
            cur.next = cur.next.next;
        }
    }
}
