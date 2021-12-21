package com.linkedList.actualCombat;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/12
 * <p>
 * <p>
 * 反转链表
 */
public class ReverseLinkedList {


    /**
     * 单链表
     */
    public static class Node {
        int element;
        Node next;

        public Node(int data) {
            this.element = data;
        }
    }


    /**
     * 双链表
     *
     * @param <E>
     */
    public static class DoubleNode {
        int element;
        DoubleNode prev;
        DoubleNode next;

        public DoubleNode(int data) {
            this.element = data;
        }
    }


    /**
     * 单链表反转
     *
     * @return
     */
    public static Node reverseLinkedList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node next = null;
        Node pre = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 双向链表反转
     *
     * @return
     */
    public static DoubleNode reverseLinkedList(DoubleNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        DoubleNode next = null;
        DoubleNode prev = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
        return prev;

    }

}
