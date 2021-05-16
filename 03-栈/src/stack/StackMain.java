package stack;

public class StackMain {

    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(22);
        stack.push(44);
        while (!stack.isEmpty()){
            System.out.println("栈的元素数量：" +stack.size());
            System.out.println( "删除栈的顶部元素"+stack.pop());

        }

    }
}
