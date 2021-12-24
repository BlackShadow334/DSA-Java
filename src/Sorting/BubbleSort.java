package Sorting;

import java.util.Arrays;

public class BubbleSort {
    // best - O(n) time
    // worst - O(n^2) time
    // O(1) space
    public static void bubbleSort(int[] arr){
        // In ascending order
        boolean is_sorted;
        for (int i = 0; i < arr.length; i++){
            is_sorted = true;
            for (int j = 1; j < arr.length - i; j++){
                if (arr[j-1] > arr[j]){
                    swap(arr, j-1, j);
                    is_sorted = false;
                }
            }
            if (is_sorted) return;
        }
    }

    private static void swap (int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main (String[] args){
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 1};

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
