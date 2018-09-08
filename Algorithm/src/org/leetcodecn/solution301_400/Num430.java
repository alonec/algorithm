package org.leetcodecn.solution301_400;

import org.leetcodecn.ListNode;
import org.omg.CORBA.NO_IMPLEMENT;

/**
 * describe:  扁平化多级双向链表
 *7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * @author alonec
 * @date 2018/09/07
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node() {}
    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}
public class Num430 {
    //*7---8---9---10--NULL
//    *    |
//    *    11--12--NULL
    public static void main(String[] args) {
        /*Node node7= new Node(7, null, null, null);
        Node node8 = new Node(8, null, null, null);
        Node node9 = new Node(9, null, null, null);
        Node node10 = new Node(10, null, null, null);
        Node node11 = new Node(11, null, null, null);
        Node node12 = new Node(12, null, null, null);
        node7.next = node8; // 7
        node8.prev = node7; node8.next = node9; node8.child = node11; // 8
        node9.prev = node8; node9.next = node10; // 9
        node10.prev = node9;  // 10
        node11.prev = node8; node11.next = node12; // 11
        node12.prev = node11; // 12*/
        Node node7= new Node(7, null, null, null);
        Node node8 = new Node(8, null, null, null);
        Node node9 = new Node(9, null, null, null);
        Node node10 = new Node(10, null, null, null);
        Node node11 = new Node(11, null, null, null);
        Node node12 = new Node(12, null, null, null);
        node7.next = node8; // 7
        node8.prev = node7; node8.next = node9; node8.child = node11; // 8
        node9.prev = node8; node9.next = node10; // 9
        node10.prev = node9;  // 10
        node11.prev = node8; node11.next = node12; // 11
        node12.prev = node11; // 12

        Node head = flatten(node7);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static Node flatten(Node head) {
        Node p = head;
        while (p != null) {
            Node cur = p;
            if (p.child != null) { // 将child扁平化
                Node child = flatten(p.child); // child被扁平化
                p.child = null;
                cur = child;
                while (cur.next != null) {
                    cur = cur.next;
                }
                if (p.next == null) { // p是最后一个next节点，则直接将child挂在p.next上
                    p.next = child;
                    child.prev = p;
                }else {
                    cur.next = p.next;
                    p.next.prev = cur;
                    p.next = child;
                    child.prev = p;
                }
            }
            p = cur.next;
        }
        return head;
    }
}
