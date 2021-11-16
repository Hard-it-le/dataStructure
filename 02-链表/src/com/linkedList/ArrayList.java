package com.linkedList;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/16
 */
public class ArrayList<E> extends AbstractList<E> {

    // 所有的元素
    private E[] elements;

    // 初始容量
    private static final int DEFAULT_CAPACITY = 10;

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        // 复制
        elements[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return old;
    }

    /**
     * 查看元素的索引
     * 首先判断数组元素是否为空，如果为空，则遍历elements数组中元素是否等于null,如果相等则返回i,
     * 如果数组元素不为空，则遍历elements数组，通过equals来判断数组元素是否相等，如果相等则返回i。
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {

        if (null == element) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }

        return ELEMENT_NOT_FOUND;
    }


    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("size=" + oldCapacity + ", 扩容到了" + newCapacity);
    }
}
