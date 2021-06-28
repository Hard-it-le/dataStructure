package stack;


import stack.list.ArrayList;
import stack.list.List;

/**
 * 栈是一种特殊的线性表，只能在一端进行操作
 * 1、往栈里面添加元素的操作，一般叫做push，入栈
 * 2、从栈里面移除元素的操作，一般叫pop。出栈（只能移除顶层元素）
 * 3、栈尊守先进后出，后进先出的原则
 * 4、栈主要操作是在尾部添加或者删除元素
 */
public class Stack<E> {
    //使用动态数据实现栈
    private List<E> list = new ArrayList<>();

    //元素的数量
    public int size() {
        // 栈中元素数量, 就是列表中存储的元素数量
        return list.size();
    }

    //是否为空
    public boolean isEmpty() {
        // 栈是否空, 就是列表是否空
        return list.isEmpty();
    }

    //添加栈的元素
    public void push(E element) {
        // 入栈, 将元素添加到列表的最后面
        list.add(element);
    }

    //移除栈的元素
    public E pop() {
        // 出栈, 将列表中最后一个元素删除并返回
        return
                list.remove(list.size() - 1);
    }

    // 获取栈顶元素
    public E top() {
        // 查看栈顶元素, 就是查看列表中的最后一个元素
        return
                list.get(list.size() - 1);
    }

    public void clear() {
        // 清空栈, 就是清空列表
        list.clear();
    }


}
