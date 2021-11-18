package com.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/18
 * <p>
 * 栈是一种特殊的线性表，只能在一端进行操作
 * 1、往栈里面添加元素的操作，一般叫做push，入栈
 * 2、从栈里面移除元素的操作，一般叫pop。出栈（只能移除顶层元素）
 * 3、栈尊守先进后出，后进先出的原则
 * 4、栈主要操作是在尾部添加或者删除元素
 * 栈底 =======================    栈顶
 * 栈底  11 22 33 44 55 66 77      栈顶
 * 栈底 =======================    栈顶
 */
public class Stack<E> {

    private List<E> list = new ArrayList();


    /**
     * 栈内是否有元素
     *
     * @return
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * 获取栈的长度
     *
     * @return
     */
    public int size() {
        return list.size();
    }


    /**
     * 从栈顶添加元素 - 入栈
     *
     * @param element
     * @return
     */
    public E push(E element) {
        list.add(element);
        return element;
    }

    /**
     * 从栈顶移除元素-出栈
     *
     * @return
     */
    public E pop() {
        return list.remove(list.size() - 1);
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    public E peek() {
        return list.get(list.size() - 1);
    }

    /**
     * 清除所有的栈内元素
     */
    public void clear() {
        list.clear();
    }
}
