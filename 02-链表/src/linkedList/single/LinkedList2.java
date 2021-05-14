package linkedList.single;


import linkedList.AbstractList;

/**
 * 链表: 单向链表
 * 虚拟头节点
 */
public class LinkedList2<E> extends AbstractList<E> {

    //下一个节点的地址
    private Node<E> first;

    public  LinkedList2(){
        first=new Node<>(null,null);
    }

    //内部类
    private static class Node<E> {
        //节点存储的元素
        E element;
        //指向后继节点
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
        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 根据链表位置获取对应的链表元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        // node方法中已经判断了索引是否越界
        return node(index).element;
    }

    /**
     * 设置链表
     * 1、取出原来的元素
     * 2、新增的元素方法原来元素的位置
     * 3、返回原来的元素
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        // 找到对应节点, node方法中已经判断了索引是否越界
        Node<E> node = node(index);
        // 记录旧元素
        E old = node.element;
        // 覆盖元素
        node.element = element;
        // 返回旧元素
        return old;
    }

    /**
     * 添加链表中的元素
     * 1、根据当前索引的找到当前索引的上一个链表
     * 2、上一个链表的地址指向老的地址
     * 3、
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        //检查索引是否越界
        rangeCheckForAdd(index);
        //找到指定位置前面的节点
        Node<E> prev = index == 0 ? first : node(index - 1);
        //将前面节点的next指向新节点，新节点的next指向prev之前的指向节点
        prev.next = new Node<>(element, prev.next);
        size++;
    }

    /**
     * 删除某个位置的链表
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        //检查数据是否越界
        rangeCheck(index);
        //找到前一个元素
        Node<E> prev = index == 0 ? first : node(index - 1);
        //记录需要删除的节点
        Node<E> node = prev.next;
        //将prev的next指向需要删除节点的后一个节点
        prev.next = node.next;
        size--;
        // 返回删除的元素
        return node.element;
    }

    /**
     * 查看元素的位置
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        //取出头节点
        Node<E> node = first;
        //当element元素为null的处理
        if (element == null) {
            //遍历节点，找到存储为null的节点，返回索引
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            //遍历节点，找到存储元素与指定元素相等的节点，返回索引
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        // 没有找到元素对应的节点, 返回ELEMENT_ON_FOUND
        return ELEMENT_NOT_FOUND;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size = ").append(size).append(", [");
        Node<E> node = first.next;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(",");
            }
            string.append(node.element);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
