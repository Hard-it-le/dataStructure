package linkedList;


/**
 * 链表:
 * 注意边界的问题
 */
public class LinkedList<E> extends AbstractList<E> {

    //下一个节点的地址
    private Node<E> first;

    //内部类
    private static class Node<E> {
        //节点存储的元素
        E element;
        //存放下一个节点的地址
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 清空链表
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    /**
     * 根据索引找到节点
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 根据链表位置获取对应的链表元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     *设置链表
     * 1、取出原来的元素
     * 2、新增的元素方法原来元素的位置
     * 3、返回原来的元素
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
     *添加链表中的元素
     * 1、根据当前索引的找到当前索引的上一个链表
     * 2、上一个链表的地址指向老的地址
     * 3、
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;

    }

    /**
     *删除某个位置的链表
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        Node<E> node = first;
        if (index == 0) {
            node = first;
            first = first.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    /**
     *查看元素的位置
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            Node<E> node  = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node.element);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
