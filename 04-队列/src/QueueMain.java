public class QueueMain {
    public static void main(String[] args) {
//        Queue<Integer> queue = new Queue<>();
//
//        queue.enQueue(11);
//        queue.enQueue(22);
//        queue.enQueue(33);
//        queue.enQueue(44);
//        while (!queue.isEmpty()){
//            System.out.println(queue.deQueue());
//        }


        Deque deque = new Deque();
        deque.enQueueFront(11);
        deque.enQueueFront(22);
        deque.enQueueRear(33);
        deque.enQueueRear(44);
        while (!deque.isEmpty()){
            System.out.println(deque.deQueueRear());
        }
    }
}
