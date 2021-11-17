package array;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/16
 * 动态数组源码解析
 */
public class ArrayList<E> {
    //元素的数量
    private int size;

    //所有的元素
    private E[] elements;

    //初始容量
    private static final int DEFAULT_CAPACITY = 10;

    //查找不到元素就-1
    private static final int ELEMENT_NOT_FOUND = -1;


    /**
     * 有参构造
     *
     * @param capacity
     */
    public ArrayList(int capacity) {
        //容量小于10一律扩充为10，三元表达式
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    /**
     * 无参构造，默认创建长度为10的数组
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
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
     * 如果数组的数量==0 则表示该数组为空
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
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 在index位置插入一个元素
     * 时间复杂度
     * 最好： O(1)
     * 最坏：O(n)
     * 平均：O(n)
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        //检查下标是否越界
        rangeCheckForAdd(index);
        // 确保容量够大
        ensureCapacity(size + 1);
        // 0 1 2 3 4 5 6 7 8 9	(index)
        // 1 2 3 4 5 6 x x x x	(原数组)
        // 在index=2处，插入9，元素全部后移
        // 1 2 9 3 4 5 6 x x x	(add后数组)
        // 先从后往前开始, 将每个元素往后移一位, 然后再赋值
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        // 复制
        elements[index] = element;
        size++;
    }

    /**
     * 添加元素到数组最后
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 获取index位置的元素
     * index表示数组的下标
     * 时间复杂度O(1)，随机访问很快
     *
     * @param index
     * @param index
     * @return 原来的元素ֵ
     */
    public E get(int index) {
        //检验下标是否越界
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * 先获取原来的元素，然后把新增的元素替换到原来的元素位置，并且返回原来index位置的元素
     * 时间复杂度O(1)
     *
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 删除index位置的元素
     * 根据index查找index位置ide元素，然后通过对数组进行遍历，
     * 遍历初始值是index,并且长度是数组数量-1，
     * 然后从index位置到size-1的位置开始往前移动一位，并且将最后一位设置为null,然后返回被删除的元素
     * 时间复杂度
     * 最好：O（1）
     * 最坏：O(n)
     * 最坏：O(n)
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        trimToSize();
        E old = elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return old;
    }


    public void remove(E element) {
        remove(indexOf(element));
    }

    /**
     * 查看元素的索引
     * 首先判断数组元素是否为空，如果为空，则遍历elements数组中元素是否等于null,如果相等则返回i,
     * 如果数组元素不为空，则遍历elements数组，通过equals来判断数组元素是否相等，如果相等则返回i。
     *
     * @param element
     * @return
     */
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

    /**
     * 遍历elements数组，然后使elements[i]每个数组都赋值为null，然后在设置size=0；
     * 清除所有元素
     */
    public void clear() {
        // 使用泛型数组后要注意内存管理(将元素置null)
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        if (elements != null && elements.length > DEFAULT_CAPACITY) {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }

    }

    /**
     * 1.获取elements数组的长度，然后判断数组的长度是否大于新数组的长度，
     * 如果大于则不扩容，否则则扩容1.5=>相当于旧容量的1.5倍，
     * 然后new一个新的数组，容量为新容量
     * 遍历原数组，把原数组的元素拷贝到新数组中。
     * 数组扩容操作
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            // 拷贝原数组元素到新数组
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("size=" + oldCapacity + ", 扩容到了" + newCapacity);

    }

    /**
     * 动态缩容
     */
    private void trimToSize() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity >> 1;
        if (size >= (newCapacity) || oldCapacity <= DEFAULT_CAPACITY) {
            return;
        }
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            // 拷贝原数组元素到新数组
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("size=" + oldCapacity + ", 缩容到" + newCapacity);

    }

    /****************封装好的功能函数**************************/
    /**
     * 下标越界抛出的异常
     *
     * @param index
     */
    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    /**
     * 检查下标越界(不可访问或删除size位置)
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /**
     * 检查add()的下标越界(可以在size位置添加元素)
     *
     * @param index
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    /****************封装好的功能函数***************************/
    @Override
    public String toString() {
        // 打印形式为: size=5, [99, 88, 77, 66, 55]
        StringBuilder string = new StringBuilder(size);
        StringBuilder append = string.append("size=")
                .append(size)
                .append(", [");
        for (int i = 0; i < size; i++) {
            if (0 != i) {
                append.append(", ");
            }
            append.append(elements[i]);
        }
        append.append("]");
        return append.toString();
    }
}
