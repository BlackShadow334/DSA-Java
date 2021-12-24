package Sorting;

import java.util.Arrays;

public class SelectionSort {
    // best -- O(^2) time
    // worst -- O(^2) time
    // O(1) space
    public static void selectionSort(int[] arr){
        // ascending order
        for (int i = 0; i < arr.length; i++){
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[i])
                    min_index = j;
            }
            swap(arr, i, min_index);
        }
    }

    private static void swap (int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main (String[] args){
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
        int[] arr = {2, 3, 4};

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
