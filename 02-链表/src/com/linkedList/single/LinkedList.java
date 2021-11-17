package com.linkedList.single;

import com.linkedList.AbstractList;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/16
 */
public class LinkedList<E> extends AbstractList<E> {
    private int size;
    private Node firstNode;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 获取index位置对应节点对象
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.next;

        }
        return node;
    }

    /**
     * 清空整个链表
     */
    @Override
    public void clear() {
        firstNode = null;
        size = 0;
    }

    /**
     * 获取某个元素的位置
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        Node<E> node = node(index);
        return node.element;
    }

    /**
     * 设置某个位置的元素
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    /**
     * 添加元素
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            Node<E> newNode = new Node<>(element, firstNode);
            firstNode = newNode;
        } else {
            Node<E> prev = node(index - 1);
            Node<E> newNode = new Node<>(element, prev.next);
            prev.next = newNode;
        }
        size++;
    }

    /**
     * 移除元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        if (index == 0) {
            firstNode = firstNode.next;
        } else {
            Node<E> prev = node(index - 1);
            prev.next = prev.next.next;

        }
        size--;

        return node.element;
    }

    /**
     * 获取元素对应的索引
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        Node<E> node = firstNode;
        if (null == element) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(size);
        StringBuilder append = string.append("size = ").append(size).append(", [");
        Node<E> node = firstNode;
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
