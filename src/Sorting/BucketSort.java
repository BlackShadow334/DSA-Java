package Sorting;

import java.util.*;

public class BucketSort {
    // O(n) to O(n^2) time , depending on implementation.
    // higher the number of buckets, faster algorithm, takes more space.
    // complexity also depends on which sorting algorithm it used internally.
    public static void bucketSort(int[] array, int number_of_buckets){
        int i = 0;
        for (var bucket: createBuckets(array, number_of_buckets)){
            Collections.sort(bucket);
            for (int item: bucket)
                array[i++] = item;
        }
    }

    private static List<List<Integer>> createBuckets(int[] array, int number_of_buckets){
        List<List<Integer>> buckets = new LinkedList<>();
        for (int i = 0; i < number_of_buckets; i++)
            buckets.add(new ArrayList<>());

        // index of bucket, in which item should be stored is (item/number_of_buckets)
        for (int item : array)
            buckets.get(item/number_of_buckets).add(item);

        return buckets;
    }

    public static void main (String[] args){
//        int[] arr = {9, 8, 7, 10, 5, 4, 30, 2, 1, 1}; // we can't take here 3 as num_of_buckets.
        int[] arr = {7, 1, 3, 5, 3};

        // Note: We can't take number_of_buckets more than upper bound.

        bucketSort(arr,3);
        System.out.println(Arrays.toString(arr));
    }
}
