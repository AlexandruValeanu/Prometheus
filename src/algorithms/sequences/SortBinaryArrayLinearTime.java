package algorithms.sequences;

/**
 * Given an binary array, sort it in linear time and constant space.
 * Output should print contain all zeroes followed by all ones.
 * Complexity: O(N)
 */
public class SortBinaryArrayLinearTime {
    private SortBinaryArrayLinearTime(){
    }

    public static void sort(int[] array){
        int zeros = 0;

        for (int e: array)
            if (e == 0)
                zeros++;

        int i = 0;

        while (zeros > 0){
            array[i++] = 0;
            zeros++;
        }

        while (i < array.length){
            array[i++] = 1;
        }
    }

    public static void test(){
        int arr[] = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };
        sort(arr);


    }
}
