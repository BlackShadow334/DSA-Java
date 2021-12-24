package Sorting;

import java.util.Arrays;

public class InsertionSort {
    // best -- O(n) time
    // worst -- O(n^2) time
    // O(1) space
    public static void insertionSort(int[] arr){
        // ascending....
        for (int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }

    public static void main (String[] args){
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
        int[] arr = {2, 1, 8};

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
