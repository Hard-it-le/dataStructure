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
        return size == 0 ;
    }

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    public boolean contains(int element) {
        return true;
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    public void add(int index, int element) {

    }

    /**
     * 添加元素到数组最后
     */
    public void add(int element) {
    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @param
     * @return 原来的元素ֵ
     */
    public int get(int index) {
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
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
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
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
        return 0;
    }

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    public int indexOf(int element) {
        return 0;
    }

    /**
     * 扩容操作
     */
    private void ensureCapacity(int capacity) {

    }


}
