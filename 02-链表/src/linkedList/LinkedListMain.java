package linkedList;

/**
 * 链表:是一种链式存储的线性表,所有的元素的内存地址都不一定是连续的
 * 链表中至少有一个size和一个first
 * size是存放的数量
 * first是存放第一个地址的节点
 */
public class LinkedListMain {
    public static void main(String[] args) {
        java.util.LinkedList<Object> linkedList1 = new java.util.LinkedList<>();
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(20);
        linkedList.add(0,10);
        linkedList.add(30);
        linkedList.add(linkedList.size(),40);
        linkedList.remove(0);
        System.out.println(linkedList);
        linkedList.indexOf(1);
        System.out.println(linkedList);

    }


}
