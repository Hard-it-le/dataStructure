package linkedList.circle;

import linkedList.AbstractList;


/**
 * 双向循环链表
 *
 * @param <E>
 */
public class doubleCycleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;
    // 指针访问当前节点
    private Node<E> current;

    private static class Node<E> {
        E element;
        Node<E> prev;
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
     * 重置当前链表
     */
    public void reset() {
        current = first;
    }

    /**
     * 当前指针访问节点指向下一个节点
     *
     * @return
     */
    public E next() {
        if (current == null) {
            return null;
        }
        current = current.next;
        return current.element;
    }

    /**
     * 删除 current 节点
     */
    public E remove() {
        if (current == null) {
            return null;
        }
        Node<E> next = current.next;
        E element = remove(current);
        if (size == 0) {
            current = null;
        } else {
            current = next;
        }
        return element;
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
        E old = node(index).element;
        node(index).element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        // 如果 index == size, 说明添加的索引是最后位置
        if (index == size) {
            //创建新节点，prev指向原链表的尾节点，next指向首节点
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, first);
            // 如果 index == size, 说明添加的索引是最后位置
            if (oldLast == null) {
                first = last;
                first.next = first;
                first.prev = first;
            } else {
                // 原链表尾节点next指向lase
                oldLast.next = last;
                // 原链表头结点prev指向last
                first.prev = last;
            }
        } else { // 正常添加元素
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
            if (next == first) {
                first = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        return remove(node(index));
    }

    public E remove(Node<E> node) {
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
                if (!node.element.equals(element)) {
                    node = node.next;
                } else {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 根据索引找到节点
     */
    private Node<E> node(int index) {
        rangeCheck(index);

        if (index < (size >> 1)) { // 索引小于一半从前往后找
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else { // 索引大于一半从后往前找
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
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
