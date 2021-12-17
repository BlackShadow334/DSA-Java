package non_linear_data_structure;

public class PriorityQueueUsingHeap {
    // here Priority Queue is simply wrapper around Heap class.

    private Heap heap;

    public PriorityQueueUsingHeap(int capacity){
        heap = new Heap(capacity);
    }

    public void enqueue(int value){
        heap.insert(value);
    }

    public int dequeue(){
        return heap.remove();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public boolean isFull(){
        return heap.isFull();
    }
}
