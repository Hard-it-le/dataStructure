package com.stack;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/18
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(11);
        System.out.println("栈顶元素是" + stack.peek());
        stack.push(22);
        System.out.println("栈顶元素是" + stack.peek());
        stack.push(33);
        System.out.println("栈顶元素是" + stack.peek());
        stack.push(44);
        System.out.println("栈顶元素是" + stack.peek());
        stack.push(55);
        System.out.println("栈顶元素是" + stack.peek());
        stack.push(66);
        System.out.println("栈顶元素是" + stack.peek());
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            if (stack.size() == 1) {
                System.out.print(stack.pop());
            } else {
                System.out.print(stack.pop() + "\t\t");
            }
        }
    }
}
