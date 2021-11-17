package com.linkedList.doubly;


import com.linkedList.AbstractList;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/17
 * <p>
 * 双向链表
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
            for (int i = size-1; i > index; i--) {
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
            //插入位置的原节点，即为新节点的next节点。
            Node<E> next = node(index);
            //新添加节点的上一个节点，即为该位置原节点的上一个节点。
            Node<E> prev = next.prev;
            //创建新添加节点。
            Node<E> node = new Node<>(prev, element, next);
            //原节点的上一个节点，为新添加节点。
            next.prev = node;
            //如果index =0，则表示头部插入
            if (prev == null) {
                first = node;
            } else {
                //原节点上一个节点的next，即为新添加节点。
                prev.next = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        // 需要删除的节点
        Node<E> node = node(index);
        // 删除节点的前一个节点
        Node<E> prev = node.prev;
        // 删除节点的后一个节点
        Node<E> next = node.next;
        // 删除节点, 只需要去掉对这个节点的引用即可
        // 如果prev == null, 说明删除的是第一个节点
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }
        // 如果next == null, 说明删除的是最后一个节点
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
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == element) {
                    return i;
                }
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) {
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
        string.append("[size=").append(size).append(", ");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
