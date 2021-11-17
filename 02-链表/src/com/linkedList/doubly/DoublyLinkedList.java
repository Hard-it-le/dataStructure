package com.linkedList.doubly;


import com.linkedList.AbstractList;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/17
 */
public class DoublyLinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    private Node<E> last;

    private static class Node<E> {
        Node<E> prev;
        E element;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 获取index位置对应的节点对象
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < size; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }


    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        return node.element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        // index = size,则表示尾部插入
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, null);
            //空链表添加第一个元素
            if (oldLast == null) {
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            //正常情况，中间插入
            rangeCheckForAdd(index);
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;
            //如果index =0，则表示头部插入
            if (prev == null) {
                first = node;
            } else {
                prev.next = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        // 头部删除 index == 0
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }
        // 尾部删除 index == size - 1
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == element) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }
}
