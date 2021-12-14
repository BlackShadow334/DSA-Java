package linear_data_structure;

import java.util.Arrays;

public class QueueUsingArray {
    private int[] items;
    private int front;
    private int rear;
    private int count = 0;

    QueueUsingArray(int size){
        items = new int[size];
        front = rear = 0;
    }

    public void enqueue(int item){
        if (isFull()) throw new IllegalStateException();
        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue(){
        if (isEmpty()) throw new IllegalStateException();
        int temp = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return temp;
    }

    public int peek(){
        if (isEmpty()) throw new IllegalStateException();
        return front;
    }

    public boolean isEmpty(){
        return count == 0;
    }
    public boolean isFull() { return count == items.length; }

    @Override
    public String toString(){
        int[] temp_arr = new int[count];
        int j = front;
        for (int i = 0; i < count; i++){
            temp_arr[i] = items[j];
            j = (j + 1) % items.length;
        }
        return Arrays.toString(temp_arr);
    }
}
