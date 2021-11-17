package com.linkedList.single;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/16
 * 链表
 */
public class Main {
    public static void main(String[] args) {
        LinkedListHeadNode<Object> linkedListHeadNode = new LinkedListHeadNode<>();
        linkedListHeadNode.add(0, 12);
        linkedListHeadNode.add(1, 40);
        linkedListHeadNode.add(2, 50);
        linkedListHeadNode.add(90);

        System.out.println(linkedListHeadNode.toString());

        linkedListHeadNode.remove(3);
        System.out.println(linkedListHeadNode.toString());

        linkedListHeadNode.add(23);
        linkedListHeadNode.add(60);
        System.out.println(linkedListHeadNode.toString());

    }
}
