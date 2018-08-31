package org.leftgod01.day08;

import org.leftgod01.Node;

import java.util.ArrayList;

/**
 * describe: 第一章第三题
 * 给定一个链表list， 如果： list = 1 调整之后1。
 * list = 1->2 调整之后1->2
 * list = 1->2->3 调整之后1->2->3
 * list = 1->2->3->4 调整之后1->3->2->4
 * list = 1->2->3->4->5 调整之后1->3->2->4->5
 * list = 1->2->3->4->5->6 调整之后1->4->2->5->3->6
 * list = 1->2->3->4->5->6->7 调整之后1->4->2->5->3->6->7
 * 根据上面的规律，调整一个任意长度的链表。
 * @author alonec
 * @date 2018/08/31
 */
public class Solution03 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
//        head.next.next.next.next.next.next = new Node(7);

        method2(head);
//        method1(head);
        while (head != null) {
            System.out.print(head.val + "   ");
            head = head.next;
        }
    }

    /**
     * 不需要辅助内存
     * @param head
     */
    private static void method2(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        Node slow;
        Node fast;
        Node cur;
        slow = cur = head;
        fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        cur = slow;
        slow = slow.next;
        cur.next = null;
        while (slow != null){
            cur = slow;
            slow = slow.next;
            cur.next = head.next;
            head.next = cur;
            if (head.next.next != null){
                head = head.next.next;
            } else {
                head = head.next;
            }
        }
    }
    /**
     * 简单实现，需要辅助内存
     * @param head 头结点
     */
    private static void method1(Node head){
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int size = 0;
        Node cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int[] help = new int[(size & 1) == 0 ? size : (size - 1)]; // 辅助空间
        int[] arr = new int[help.length];
        cur = head;
        for (int i=0; i<arr.length; i++){ // 将链表所有元素放入数组中，如果是奇数个，则最后一个不放
            arr[i] = cur.val;
            cur = cur.next;
        }
        for (int i=0; i<arr.length; i++){
            if (i < size / 2){
                help[i * 2] = arr[i];
            }else {
                help[(i - arr.length / 2) *2 + 1] = arr[i]; // 插入前arr.length / 2 个元素中
            }
        }
        cur = head;
        for (int i=0; i<help.length; i++){
            cur.val = help[i]; // 放回链表
            cur = cur.next;
        }
    }
}
