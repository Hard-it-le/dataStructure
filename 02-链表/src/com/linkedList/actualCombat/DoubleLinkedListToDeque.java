package com.linkedList.actualCombat;


/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/12
 * 双向链表实现双端队列
 */
public class DoubleLinkedListToDeque {

    public static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;


        public Node(T value) {
            this.value = value;

        }
    }

    public static class DoubleEndsQueue<T> {
        Node<T> head;

        Node<T> tail;

        public void addFromHead(T value) {
            Node<T> cur = new Node<T>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.prev = cur;
                head = cur;
            }
        }
    }
}
