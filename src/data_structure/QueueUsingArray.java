package data_structure;

import java.util.Arrays;

public class QueueUsingArray {
    private int[] items;
    private int front;
    private int rear;

    QueueUsingArray(int size){
        items = new int[size];
        front = rear = 0;
    }

    public void enqueue(int item){
        if (isFull()) throw new IllegalStateException();
        if (rear == items.length) {
            int[] temp_arr = new int[items.length];
            int j = 0;
            for (int i = front; i < rear; i++)
                temp_arr[j++] = items[i];

            items = temp_arr;
            front = 0;
            rear = j;
        }

        items[rear++] = item;
    }

    public int dequeue(){
        if (isEmpty()) throw new IllegalStateException();
        return front++;
    }

    public int peek(){
        if (isEmpty()) throw new IllegalStateException();
        return front;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return (front == 0) && (rear == items.length);
    }

    @Override
    public String toString(){
        int[] temp_arr = new int[rear - front];
        int j = front;
        for (int i = 0; i < temp_arr.length; i++)
            temp_arr[i] = items[j++];
        return Arrays.toString(temp_arr);
    }
}
