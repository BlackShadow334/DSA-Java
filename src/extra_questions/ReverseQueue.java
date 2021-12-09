package extra_questions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class ReverseQueue {
    static void reverseQueue(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    public static void main(String[] args){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        queue.add(1);
        queue.add(2);
        queue.add(3);

        reverseQueue(queue);
        
        System.out.println(queue);
    }
}
