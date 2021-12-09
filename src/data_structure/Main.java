package data_structure;

public class Main {
    public static void main(String[] args){
        UserPriorityQueue queue = new UserPriorityQueue(5);

        queue.enqueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(10);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(5);
//        queue.enqueue(6);
        System.out.println(queue.isEmpty());
        System.out.println(queue);

    }
}
