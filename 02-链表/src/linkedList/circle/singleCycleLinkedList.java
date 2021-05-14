package linkedList.circle;

import linkedList.AbstractList;

/**
 * 单向循环链表
 */
public class singleCycleLinkedList<E> extends AbstractList<E> {

    //下一个节点的地址
    private Node<E> first;

    private static class Node<E> {
        //节点存储的元素
        E element;
        //后继节点
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(element).append("_").append(next.element);
            return sb.toString();
        }

    }

    /**
     * 根据索引值找到节点
     *
     * @param index
     * @return
     */
    public Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    /**
     * 清空链表
     */
    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    /**
     * 获取索引对应链表元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {

        return node(index).element;
    }

    /**
     * 根据索引设置对应的元素
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     * 添加链表
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            //首先获取到最后一个节点
            Node<E> newFirst = new Node<>(element, first);
            Node<E> last = (size == 0) ? newFirst : node(size - 1);
            last.next = newFirst;
            first = newFirst;
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            if (size == 1) {
                first = null;
            } else {
                Node<E> last = node(index - 1);
                first = first.next;
                last.next = first;
            }
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }
}
