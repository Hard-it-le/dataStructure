package com.linkedList;

import com.linkedList.doubly.DoublyLinkedList;
import com.linkedList.single.LinkedList;

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

        public Node(int element, Node next) {
            this.element = element;
            this.next = next;
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

        public DoubleNode(int element, DoubleNode prev, DoubleNode next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
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
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = next;
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

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.toString();

    }

}
