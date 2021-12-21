package com.linkedList.actualCombat;


import com.linkedList.single.LinkedList;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/12
 * <p>
 * 单链表实现栈
 */
public class LinkedListToStack<T> {

    private LinkedList linkedList;


    /**
     * 进栈
     *
     * @param value
     */
    public void pushStack(int value) {
        linkedList.add(value);
    }

    /**
     * 出栈
     *
     * @return
     */
    public T popStack() {

        int size = linkedList.size();
        return (T) linkedList.remove(size);
    }

    /**
     * 返回栈顶元素
     *
     * @return
     */
    public T peek() {
        return (T) linkedList.get(linkedList.size());
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        boolean empty = linkedList.isEmpty();
        return empty;
    }
}
