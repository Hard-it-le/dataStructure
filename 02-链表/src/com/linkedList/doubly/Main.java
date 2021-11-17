package com.linkedList.doubly;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/17
 */
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Object> doublyLinkedList = new DoublyLinkedList<>();

       doublyLinkedList.add(11);
       doublyLinkedList.add(22);
       doublyLinkedList.add(33);
       doublyLinkedList.add(44);
//       doublyLinkedList.add(0,55);
//       doublyLinkedList.add(2,66);
      // doublyLinkedList.add(doublyLinkedList.size(),77);
       System.out.println(doublyLinkedList.toString());
        System.out.println(doublyLinkedList.get(1));
        doublyLinkedList.add(0,55);
        doublyLinkedList.add(2,66);
        System.out.println(doublyLinkedList.toString());
    }
}
