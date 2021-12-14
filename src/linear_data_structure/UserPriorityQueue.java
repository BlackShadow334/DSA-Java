package linear_data_structure;

import java.util.Arrays;

public class UserPriorityQueue {
    private final int[] items;
    private int count = 0;

    UserPriorityQueue(int capacity){
        items = new int[capacity];
    }

    public void enqueue(int item){
        if (isFull()) throw new IllegalStateException();
        if (isEmpty()) {
            items[count++] = item;
            System.out.println("empty");
            return;
        }
        // Shifting items
        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    public int dequeue(){
        if (isEmpty()) throw new IllegalStateException();
        int temp = items[count-1];
        items[count - 1] = 0;
        count--;
        return temp;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }

    private int shiftItemsToInsert(int item){
        int i = count - 1;
        while (i >= 0 && items[i] >= item){
            items[i + 1] = items[i];
            i--;
        }
        // returning index for placing item
        return i + 1;
    }
}
