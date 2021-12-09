package data_structure;

import java.util.Stack;

public class QueueUsingStack {
    // stack1 is for enqueue
    // stack2 is for dequeue
    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    QueueUsingStack(){
    }

    // O(1)
    public void enqueue(int item){
        stack1.push(item);
    }

    // O(n)
    public int dequeue(){
        if (isEmpty()) throw new IllegalStateException();
        if (stack2.isEmpty())
            moveStack1ToStack2();
        return stack2.pop();
    }
    // O(n)
    public int peek(){
        if (isEmpty()) throw new IllegalStateException();
        if (stack2.isEmpty())
            moveStack1ToStack2();
        return stack2.peek();
    }

    public boolean isEmpty(){
        return stack1.isEmpty()&& stack2.isEmpty();
    }

    @Override
    public String toString(){
        return stack1.toString() + stack2.toString();
    }

    private void moveStack1ToStack2(){
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
    }
}
