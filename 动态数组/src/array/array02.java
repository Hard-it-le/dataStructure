package array;

import java.util.Arrays;

public class array02 {
    //数组
    private int[] data;
    //数组的长度
    private int size;

    //无参构造函数,默认数组容量是10
    public array02() {
        this(10);
    }

    //有参构造函数,传入数组容量并且构造array
    public array02(int capacity) {
        data = new int[capacity];
        size = data.length;
    }


    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //获取数组参数
    public int[] getData() {
        return data;
    }

    //向数组最后一个添加数据
    public void addArrayLast(int e) throws IllegalAccessException {
        //判断数组存在的数值长度是否等于数组长度
        if (size == data.length) {
            throw new IllegalAccessException("数组已满");
        }
        data[size] = e;
        size++;
    }

    //向数组中任意位置插入数据
    public void addrandomArray(int index, int e) throws IllegalAccessException {
        if (size == data.length) {
            throw new IllegalAccessException("数组已满");
        }
        if (index < 0 || index > size) {
            throw new IllegalAccessException("index >= 0 && index <= size");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
            data[index] = e;
            size++;
            System.out.println(data[index]);
        }
    }

    //获取index索引位置的元素
    int get(int index) throws IllegalAccessException {
        if(isEmpty()){
            throw new IllegalAccessException("data[] is null");
        }

        if (index < 0 || index > size) {
            throw new IllegalAccessException("index >= 0 && index <= size");
        }
        return data[index];
    }

    //获取index索引位置的元素
    void set(int index, int size) throws IllegalAccessException {
        if (index < 0 || index > size) {
            throw new IllegalAccessException("index >= 0 && index <= size");
        }
        data[index] = size;
    }

    //向数据第一个位置插入新元素
    public void addFirst(int e) throws IllegalAccessException {
        addrandomArray(0, e);
    }

    //查找数据中是否存在元素e
    public boolean contains(int e) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e所在的索引,如果不存在元素e,则返回-1
    public int findIndex(int e) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }
    //删除数组中index位置的元素,返回删除的元素,
    public int deleteArray(int index)  {
        if (isEmpty()){
            return -1;
        }
        if (index <0 || index >size){
           return  -1;
        }
        int res = data[index];
        for (int i = 0; i < size; i++) {
            data[i-1] = data[i];
            size--;
        }
        return res;
    }

    //删除第一个元素
    public  int deleteFirst() {
        return  deleteArray(0);
    }

    //删除最后一个元素
    public  int deleteLast() {
        return  deleteArray(size-1);
    }


    public void setData(int[] data) {
        this.data = data;
    }

    //获取数组元素个数
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "array02{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
