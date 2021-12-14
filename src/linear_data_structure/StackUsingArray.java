package linear_data_structure;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackUsingArray {
    private final int[] items;
    private int count = 0;

    StackUsingArray(int size){
        items = new int[size];
    }

    public void push(int item){
        if (count == items.length) throw new StackOverflowError();
        items[count++] = item;
    }

    public int pop(){
        if (isEmpty()) throw new EmptyStackException();
        return items[--count];
    }

    public int peek(){
        if (isEmpty()) throw new EmptyStackException();
        return items[count - 1];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public String toString(){
        System.out.println(count);
        int[] arr = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(arr);
    }
}
