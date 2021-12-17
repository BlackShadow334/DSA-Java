package extra_questions;

public class HeapifyGivenArray {
    public static void main(String[] args){
        int[] numbers = {5, 3, 8, 4, 1, 2};
//        int[] numbers = {1,2,3,4,5,6,7};

        // Heapify above given array.
        // ie it should follow heap property.

        // Soln:

        // for Recursive method --
        for (int i = numbers.length/2 - 1; i >= 0; i--){
            heapify(i, numbers);
        }

        // for iterative method by last index
//        for (int i = numbers.length - 1; i > 0; i--){
//            bubbleUp(i, numbers);
//        }

        for(int num : numbers)
            System.out.print(num + ", ");

    }

    // Using RECURSION
    private static void heapify(int index, int[] numbers){
        int larger_index = index;

        int left_index = index * 2 + 1;
        if (left_index < numbers.length && numbers[left_index] > numbers[larger_index])
            larger_index = left_index;

        int right_index = index * 2 + 2;
        if (right_index < numbers.length && numbers[right_index] > numbers[larger_index])
            larger_index = right_index;

        if (index == larger_index)
            return;
        swap(index, larger_index, numbers);

        heapify(larger_index, numbers);
    }

    // Using ITERATION -- starting at last index and by calculating parentIndex.
    private static void bubbleUp(int index, int[] numbers){
        while (index > 0 && numbers[index] > numbers[parentIndex(index)] ) {
            swap(index, parentIndex(index), numbers);
            index = parentIndex(index);
        }
    }

    private static int parentIndex(int index){
        return (index - 1) / 2;
    }

    private static void swap(int index1, int index2, int[] numbers){
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}
