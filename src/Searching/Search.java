package Searching;

public class Search {

    public static int linearSearch(int[] array, int target) {
        // Best -- O(1) time
        // Worst -- O(n) time
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target)
                return i;
        }
        return -1;
    }


    public static int binarySearch(int[] array, int target){
        // O(log n) time
        // O(1) space
        // return binarySearchIterative(array, target);

        // O(log n) time
        // O(log n) space
        return binarySearchRec(array, target, 0, array.length-1);
    }

    private static int binarySearchIter(int[] array, int target){
        int min_i = 0;
        int max_i = array.length - 1;
        int mid_i;
        while (min_i <= max_i){
            mid_i = (min_i + max_i)/2;
            if (target == array[mid_i])
                return mid_i;
            if (target < array[mid_i])
                max_i = mid_i - 1;
            else
                min_i = mid_i + 1;
        }
        return -1;
    }

    private static int binarySearchRec(int[] array, int target, int min_i, int max_i){
        if (min_i > max_i)
            return -1;
        int mid_i = (min_i + max_i)/2;
        if (target == array[mid_i])
            return mid_i;
        else if (target < array[mid_i])
            return binarySearchRec(array, target, min_i, mid_i - 1);
        else
            return binarySearchRec(array, target, mid_i + 1, max_i);
    }

    public static int ternarySearch(int[] array, int target){
        // O(log n) time --- base 3.
        // O(1) space
        // NOTE: practically Ternary Search is slower than binary Search.

        int min_i = 0;
        int max_i = array.length -1;
        int mid1, mid2, pos_size;

        while (min_i <= max_i){
            pos_size = (max_i - min_i)/3;
            mid1 = min_i + pos_size;
            mid2 = max_i - pos_size;

            if (target > array[mid2])
                min_i = mid2 + 1;
            if (target == array[mid2])
                return mid2;
            if (target < array[mid2] && target > array[mid1]){
                min_i = mid1 + 1;
                max_i = mid2 - 1;
            }
            if (target == array[mid1])
                return mid1;
            if (target < array[mid1])
                max_i = mid1 - 1;
        }
        return -1;
    }

    public static int jumpSearch(int[] array, int target){
        // O( sqrt(n) ) time
        // O(1) space
        // extended version of linear search...

        // ideal block size = sqrt(n)
        int block_size = (int)Math.sqrt(array.length);
        int start = 0;
        int next = block_size;

        while(start < array.length && array[next-1] < target){
            start = next;
            next += block_size;
            if (next > array.length)
                next = array.length;
        }

        for (int i = start; i < next; i++){
            if (target == array[i])
                return i;
        }

        return -1;
    }

    public static int exponentialSearch(int[] array, int target){
        // O(log i) time , where i is position of target (and that is worse case)
        // uses binary search internally...

        int bound = 1;
        while (bound < array.length && array[bound] < target)
            bound *= 2;

        int min_i = bound/2;
        int max_i =  Math.min(bound, array.length-1);
        return binarySearchRec(array, target, min_i, max_i);
    }


    public static void main(String[] args) {
//        int[] array = {1, 3, 4, 5, 6, 6, 7, 9};
        int[] array = {2};

        int index = exponentialSearch(array, 3);
        System.out.println(index);
    }
}
