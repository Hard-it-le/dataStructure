package com.linkedList;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/16
 */
public abstract class AbstractList<E> implements List<E> {
    //元素的数量
    protected int size;

    /**
     * 是否有这个元素
     *
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 集合的数量
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 集合是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加集合元素
     *
     * @param element
     */
    @Override
    public void add(E element) {
        add(size, element);
    }

    /**
     * 下标越界抛出的异常
     *
     * @param index
     */
    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    /**
     * 检查下标越界(不可访问或删除size位置)
     *
     * @param index
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /**
     * 检查add()的下标越界(可以在size位置添加元素)
     *
     * @param index
     */
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}
