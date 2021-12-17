package extra_questions;

import non_linear_data_structure.Heap;

public class KthLargestUsingHeap {
    public static void main(String[] args) {

        int[] numbers = {5, 3, 8, 4, 1, 2};
        int K = 2;
        // Find the Kth largest item in above array.

        // Soln:
        // using heap
        Heap heap = new Heap(numbers.length);

        for (int num : numbers)
            heap.insert(num);

        for (int i = 0; i < K - 1; i++)
            heap.remove();

        System.out.println(heap.remove());
    }
}
