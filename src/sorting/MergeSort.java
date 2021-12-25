package sorting;

import java.util.Arrays;

public class MergeSort {
    // best -- O(n log n) time
    // worst -- O(n log n) time
    // O(n) space
    public static void mergeSort(int[] array){
        // Ascending..order..
        // base case..
        if (array.length < 2) return;

        // Divide array into halves...
        int mid_index = array.length/2;
        int[] left = new int[mid_index];
        for (int i = 0; i < mid_index; i++)
            left[i] = array[i];

        int[] right = new int[array.length - mid_index];
        for (int i = 0; i < right.length; i++)
            right[i] = array[mid_index + i];

        // Sort both halves...
        mergeSort(left);
        mergeSort(right);

        // Then merge...
        merge(left, right, array);
    }

    private static void merge(int[] left, int[] right, int[] result){
        int i = 0,left_i = 0,right_i = 0;

        while (left_i < left.length && right_i < right.length){
            if (left[left_i] <= right[right_i])
                result[i++] = left[left_i++];
            else
                result[i++] = right[right_i++];
        }

        while (left_i < left.length)
            result[i++] = left[left_i++];

        while (right_i < right.length)
            result[i++] = right[right_i++];

        // 2nd method...
        // while (i < result.length){
        //     if (left_i < left.length && right_i < right.length){
        //         if (left[left_i] < right[right_i])
        //             result[i] = left[left_i++];
        //         else
        //             result[i] = right[right_i++];
        //     }
        //     else if (left_i < left.length)
        //         result[i] = left[left_i++];
        //     else if (right_i < right.length)
        //         result[i] = right[right_i++];
        //     i++;
        // }
    }


    public static void main (String[] args){
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
//        int[] arr = {2, 1, 8};

        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
