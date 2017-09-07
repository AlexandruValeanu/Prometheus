package interview_questions;

import data_structures.pair.MutablePair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find a pair of numbers with given sum
 * Otherwise, return null.
 * Complexities: O(N^2), O(N*logN), O(N)
 * TODO better problem formulation + explanations
 */
public class FindPairWithGivenSum {
    private FindPairWithGivenSum(){
    }

    public static MutablePair<Integer, Integer> naiveFindPair(int[] array, int sum){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                // if desired sum is found, print it and return
                if (array[i] + array[j] == sum)
                    return new MutablePair<>(array[i], array[j]);
            }
        }

        return null;
    }

    public static MutablePair<Integer, Integer> sortingFindPair(int[] array, int sum){
        int[] arr = Arrays.copyOf(array, array.length);
        // sort the array in ascending order
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        // reduce search space arr[low..high] at each iteration of the loop
        while (low < high){
            if (arr[low] + arr[high] == sum)
                return new MutablePair<>(arr[low], arr[high]);

            // increment low index if total is less than the desired sum
            // decrement high index is total is more than the sum
            if (arr[low] + arr[high] < sum)
                low++;
            else
                high--;
        }

        return null;
    }

    public static MutablePair<Integer, Integer> hashingFindPair(int[] array, int sum){
        // set the contains all 'visited' elements
        Set<Integer> set = new HashSet<>();

        for (int e: array){
            // check if (sum - e) is already in set)
            if (set.contains(sum - e))
                return new MutablePair<>(e, sum - e);

            set.add(e);
        }

        return null;
    }
}
