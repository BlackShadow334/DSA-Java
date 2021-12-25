package sorting;

import java.util.Arrays;

public class CountingSort {
    // best -- O(n + K) time, where K is maximum element
    // worst -- O(n + K)
    // O(K) space
    public static void countingSort(int[] array){
        // Ascending...
        if (array.length == 0)
            return;
        int maxim = array[0];
        for (int num: array)
            maxim = Math.max(num, maxim);

        countingSort(array, maxim);
    }

    private static void countingSort(int[] array, int maxim){
        int[] count_array = new int[maxim + 1];

        for (int num : array) count_array[num]++;

        int j = 0;
        for (int i = 0; i < count_array.length; i++){
            while(count_array[i] > 0){
                array[j++] = i;
                count_array[i]--;
            }
        }
    }

    public static void main (String[] args){
        int[] arr = {9, 8, 7, 10, 5, 4, 30, 2, 1, 1};
//        int[] arr = {};

        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
