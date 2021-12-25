package non_linear_data_structure;

import java.util.Arrays;

// Applications:
//      sorting elements in array in ascending or descending order.
//      Using as Priority Queue.

public class Heap {
    // Heap is generally implemented with Array, as we can get its child or parent index easily.
    // left_child_index = parent_index * 2 + 1
    // right_child_index = parent_index * 2 + 2
    // parent_index = (current_index - 1) / 2

    private int[] items;
    private int count;

//    public Heap(){
//        items = new int[10];
//        count = 0;
//    }

    public Heap(int capacity){
        items = new int[capacity];
        count = 0;
    }

    // insert always happens at last level -> left to right.
    public void insert(int value){
        if (isEmpty()){
            items[count++] = value;
            return;
        }
        if (isFull()) throw new IllegalStateException();
        // if isFull() ,  increase capacity of items
        // .....
        // .....

        items[count++] = value;
        bubbleUp();
    }

    // remove always happens at top.
    public int remove(){
        if (isEmpty()) throw new IllegalStateException();
        int temp = items[0];
        items[0] = items[count - 1];
        items[count - 1] = 0;
        count--;

        bubbleDown();
        return temp;
    }

    private void bubbleUp(){
        int index = count - 1;
        while (index > 0 && items[index] > items[parentIndex(index)]){
            swapValues(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void bubbleDown(){
        int index = 0;
        while (index < count - 1 && !isValidParent(index)){
            int larger_child_index = largerChildIndex(index);
            swapValues(index, larger_child_index);
            index = larger_child_index;
        }
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }

    private int largerChildIndex(int index){
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);
        return (items[leftChildIndex(index)] > items[rightChildIndex(index)])?
                leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index){
        if (!hasLeftChild(index))
            return true;

        boolean is_valid = items[index] > items[leftChildIndex(index)];
        if (hasRightChild(index))
            is_valid &= items[index] > items[rightChildIndex(index)];
        return is_valid;

    }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index) < count;
    }
    private boolean hasRightChild(int index){
        return rightChildIndex(index) < count;
    }

    private int parentIndex(int index){
        return (index - 1)/2;
    }

    private int leftChildIndex(int index){
        return index * 2 + 1;
    }

    private int rightChildIndex(int index){
        return index * 2 + 2;
    }

    private void swapValues(int index1, int index2){
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    @Override
    public String toString(){
        return Arrays.toString(items) + " count: " + count;
    }
}
