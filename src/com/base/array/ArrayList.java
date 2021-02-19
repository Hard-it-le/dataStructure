package com.base.array;

/**
 * 动态数组
 */
public class ArrayList {

    //数量
    private int size;
    //所有的元素数组
    private int[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    private static final int ELEMENT_NO_FOUND = -1;

    /**
     * 无参构造函数
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 有参构造函数
     *
     * @param capaticy
     */
    public ArrayList(int capaticy) {
        //判断capaticy是否等于0,三元表达式
        //capaticy =(capaticy<DEFAULT_CAPACITY)?DEFAULT_CAPACITY:capaticy;
        if (capaticy <= DEFAULT_CAPACITY) {
            capaticy = DEFAULT_CAPACITY;
        } else {
            capaticy = capaticy;
        }
        elements = new int[capaticy];
    }


    /**
     * 清除所有元素
     */
    public void clear() {
        size = 0;
    }

    /**
     * 元素的数量
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    public boolean contains(int element) {

        return indexOf(element) != ELEMENT_NO_FOUND;
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    public void add(int index, int element) {rangeCheckForAdd(index);
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 添加元素到数组最后
     */
    public void add(int element) {
        add(size,element);
        // elements[size++]=element;
    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @param
     * @return 原来的元素ֵ
     */
    public int get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    public int set(int index, int element) {
        rangeCheck(index);
        int old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 删除index位置的元素
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        rangeCheck(index);
        int old = elements[index];
        for (int i = index + 1; i < size - 1; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return old;
    }

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return ELEMENT_NO_FOUND;
    }

    /**
     * 扩容操作
     */
    private void ensureCapacity(int capacity) {

    }

    /****************封装好的功能函数**************************/
    // 下标越界抛出的异常
    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }
    // 检查下标越界(不可访问或删除size位置)
    private void rangeCheck(int index){
        if(index < 0 || index >= size){
            outOfBounds(index);
        }
    }
    // 检查add()的下标越界(可以在size位置添加元素)
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    /**
     * 打印数组里面的数据
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(elements[i]);
            /*if(i!=size-1){
                stringBuilder.append(",");
            }*/
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


}
