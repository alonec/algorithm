package org.leftgod.day05;

import org.leftgod.Node;
/**
 * @Auther: chenxin
 * @Date: 2018/8/13 21:43
 * @Description: 打印两个有序链表的公共部分
 * 【题目】 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 */
public class PrintTheCommonOfLinkedList {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 5};
//        int[] arr2 = {0, 1, 2, 3, 5};
        int[] arr2 = {5, 7, 8, 9, 10};
        Node head1 = new Node(arr1[0]);
        Node head2 = new Node(arr2[0]);
        Node h1 = head1;
        Node h2 = head2;
        for (int i=1; i<5; ++i){
            h1.next = new Node(arr1[i]);
            h1 = h1.next;
            h2.next = new Node(arr2[i]);
            h2 = h2.next;
        }
        new PrintTheCommonOfLinkedList().printCommon(head1, head2);
    }
    public void printCommon(Node head1, Node head2){
        while (head1 != null && head2 != null){
            if (head1.val ==  head2.val){
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
            else if (head1.val < head2.val){
                head1 = head1.next;
            }else {
                head2 = head2.next;
            }
        }
    }
}
