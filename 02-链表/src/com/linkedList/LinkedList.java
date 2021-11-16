package com.linkedList;

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
     * 清空整个链表
     */
    @Override
    public void clear() {

    }

    /**
     * 获取某个元素的位置
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return null;
    }

    /**
     * 设置某个位置的元素
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        return null;
    }

    /**
     * 添加元素
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {

    }

    /**
     * 移除元素
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        return null;
    }

    /**
     * 获取元素对应的索引
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        return 0;
    }


}
