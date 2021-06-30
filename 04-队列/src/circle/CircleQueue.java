package circle;

/**
 * 循环队列
 * <p>
 * 队列的底层也可以用动态数据实现，并且接口的复杂度可以到O（1）的时间复杂度
 */
public class CircleQueue<E> {

    /**
     * 记录第0个元素的索引
     */
    private int front;

    /**
     * 当前队列存储的元素个数**
     */
    private int size;
    /**
     * 用来存储元素的数组
     * 利用动态扩容数组实现的循环队列
     */
    private E[] elements; // 元素

    /**
     * 初始容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * 获取元素的数量
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 从队头出队
     *
     * @return
     */
    public E deQueue() {
        //获取队头的元素
        E frontElement = elements[front];
        //设置改队头的位置为null
        elements[front] = null;
        //是队列指针指向下一个元素 ，如果该队头的位置是最后一个，则指向队尾的第一个元素
        front = (front + 1) % elements.length;
        //循环队列的元素减1
        size--;
        //返回已删除的队头元素
        return frontElement;
    }

    /**
     * 获取队头的元素
     *
     * @return
     */
    public E front() {
        return elements[front];
    }

    /**
     * 从队尾入队
     * @param element
     */
    public void enQueue(E element) {
        elements[(front + size) % elements.length] = element;
        size++;
    }

    /**
     * 清空循环队列
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[size] = null;
        }
        size = 0;
        front = 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capcacity=").append(elements.length)
                .append(" size=")
                .append(size)
                .append(" front=")
                .append(front)
                .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }


//
//    /**
//     * 清空
//     */
//    public void clear() {
//        for (int i = 0; i < size; i++) {
//            elements[index(i)] = null;
//        }
//        size = 0;
//        front = 0;
//    }
//

//
//    // 将真实索引转换为循环队列上的索引
//    private int index(int index) {
//        // 10%8 = 2 10-8=2
//        // 10%11 = 10 10
////		return (front + index) % elements.length;
//        index += front;
//        return index - ((index >= elements.length) ? elements.length : 0);
//    }
//
//    // 扩容
//    private void ensureCapacity(int capacity) {
//        int oldCapacity = elements.length;
//        if (oldCapacity >= capacity)
//            return;
//        // 新容量为旧容量的 1.5 倍
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
//        E[] newElements = (E[]) new Object[newCapacity];
//        for (int i = 0; i < size; i++) { // 旧数组中元素移到新数组
//            // 	newElements[i] = elements[(i + front) % elements.length];
//            newElements[i] = elements[index(i)];
//        }
//        System.out.println("从" + oldCapacity + "扩容到" + newCapacity);
//        elements = newElements;
//        front = 0; // 重置front
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder string = new StringBuilder();
//        string.append("capcacity=").append(elements.length).append(" size=").append(size).append(" front=")
//                .append(front).append(", [");
//        for (int i = 0; i < elements.length; i++) {
//            if (i != 0) {
//                string.append(", ");
//            }
//            string.append(elements[i]);
//        }
//        string.append("]");
//        return string.toString();
//    }
}
