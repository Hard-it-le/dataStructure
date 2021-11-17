package com.linkedList.single;

import com.linkedList.AbstractList;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/17
 * <p>
 * 虚拟头节点
 */
public class LinkedListHeadNode<E> extends AbstractList<E> {

    private Node<E> first;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    public LinkedListHeadNode() {
        first = new Node<>(null, null);
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        Node<E> prev = index == 0 ? first : node(index - 1);
        prev.next = new Node<>(element, prev.next);
        size++;

    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> prev = index == 0 ? first : node(index - 1);
        Node<E> node = prev.next;
        prev.next = node.next;
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(size);
        StringBuilder append = string.append("size = ").append(size).append(", [");
        Node<E> node = first.next;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                append.append(",");
            }
            append.append(node.element);
            node = node.next;
        }
        append.append("]");
        return append.toString();
    }
}
