import list.LinkedList;
import list.List;
/**
 * 单端队列是一种特殊的线性表，只能在头尾两端操作
 * 队尾（rear）：只能从队尾添加元素，一般叫做enQueue，入队
 * 队头（front）：只能从对头移除元素，一般叫做deQueue，出队
 * 先进先出原则
 * 队列有限使用双向链表，原因：队列做要是头尾进行操作元素
 */
public class Queue<E> {

    private List<E> list = new LinkedList<>();
    //元素的数量
    public int size() {

        return list.size();
    }

    //是否为空
    public boolean isEmpty() {
        return list.isEmpty();
    }
    // 入队
    public  void enQueue(E element){
        list.add(element);
    }
    // 出队
    public E deQueue(){
        E remove = list.remove(0);
        return  remove;
    }
    // 获取队列的头元素
    public E front() {
        return list.get(0);
    }




}
