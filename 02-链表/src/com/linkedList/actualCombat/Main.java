package com.linkedList.actualCombat;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/20
 */
public class Main {

    public static void main(String[] args) {

        LinkedListToStack<Integer> stack = new LinkedListToStack<>();
        stack.pushStack(1);
        stack.pushStack(2);
        stack.pushStack(3);
        stack.pushStack(4);

        while (!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.popStack();
        }

    }
}
