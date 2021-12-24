package Sorting;

import java.util.Arrays;

public class QuickSort {
    // best -- O(n log n) time
    // worst -- O(n^2) time --> when array is sorted in ascending or descending.
    // O(log n) space
    public static void quickSort(int[] array){
        // Ascending--
        quickSort(array, 0, array.length-1);
    }

    private static void quickSort(int[] array, int start, int end){
        if (start >= end) return;
        int boundary = partition(array, start, end);
        // Sort left
        quickSort(array, start, boundary - 1);
        // Sort right
        quickSort(array, boundary + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int boundary = start - 1;

        for (int i = start; i <= end; i++)
            if (array[i] <= pivot)
                swap(array, i, ++boundary);

        return boundary;
    }


    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main (String[] args){
//        int[] arr = {9, 8, 7, 10, 5, 4, 30, 2, 1, 1};
        int[] arr = {15, 6, 3, 1, 22, 10, 13};

        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
