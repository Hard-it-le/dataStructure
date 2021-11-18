package com.linkedList.circle;

import com.linkedList.AbstractList;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/18
 */
public class DoublyCircleLinkedList<E> extends AbstractList<E> {


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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prev != null) {
                sb.append(prev.element);
            } else {
                sb.append("null");
            }
            sb.append("_").append(element).append("_");
            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }
            return sb.toString();
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
        // 判断索引是在链表前一半还是后一半，如果是前一半就从前往后找
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }


    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        // 如果 index == size, 说明添加的索引是最后位置
        if (index == size) {
            Node<E> oldLast = last;
            //创建新节点，prev指向原链表的尾节点，next指向首节点
            last = new Node<>(oldLast, element, first);
            // 如果 index == size, 说明添加的索引是最后位置
            if (oldLast == null) {
                first = last;
                first.prev = first;
                first.next = first;
            } else {
                // 原链表尾节点next指向lase
                oldLast.next = last;
                // 原链表头结点prev指向last
                first.prev = last;
            }
        } else {
            // 添加新节点后的下一个节点
            Node<E> next = node(index);
            // 添加新节点后的上一个节点
            Node<E> prev = next.prev;
            // 创建新节点, 新节点的上一个节点时prev, 新节点的下一个节点是next
            Node<E> node = new Node<>(prev, element, next);
            // next的上一个节点是新节点
            next.prev = node;
            // prev的下一个节点是新节点
            prev.next = node;
            // 当next == first时, 说明新添加节点的索引是0
            if (prev == null) {
                first = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> node = node(index);
        //需要删除节点，如果size == 1，则说明只有首节点
        if (size == 1) {
            first = null;
            last = null;
        } else {
            //删除节点的前一个节点
            Node<E> prev = node.prev;
            //删除节点的后一个节点
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;
            //如果node == first ，说明删除的是第一个节点
            if (node == first) {
                first = next;
            }
            //// index == size - 1，如果node == last，则说明删除的最后一个节点
            if (node == last) {
                last = prev;
            }
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }
}
