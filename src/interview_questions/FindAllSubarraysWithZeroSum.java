package interview_questions;

import data_structures.pair.mutable.MutablePair;

import java.util.*;

/**
 * Given an array of integers, return all sub-arrays having 0 sum.
 * Complexities: O(N^2), O(N + numberOfSolutions)
 * TODO better problem formulation + explanations
 */
public class FindAllSubarraysWithZeroSum {
    private FindAllSubarraysWithZeroSum(){
    }

    public static List<MutablePair<Integer, Integer>> naiveFindSubarrays(int[] array){
        List<MutablePair<Integer, Integer>> pairs = new ArrayList<>();

        // consider all sub-arrays starting from i
        for (int i = 0; i < array.length; i++) {
            int sum = 0;

            // consider all sub-arrays ending at j
            for (int j = i; j < array.length; j++) {
                // sum = array.sum[i, j]
                sum += array[j];

                // [i..j] has sum 0
                if (sum == 0)
                    pairs.add(new MutablePair<>(i, j));
            }
        }

        return pairs;
    }

    // Utility function to insert <key, value> into the multimap
    private static void insertMap(Map<Integer, ArrayList<Integer>> map, int key, int value){
        if (map.containsKey(key))
            map.get(key).add(value);
        else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    public static List<MutablePair<Integer, Integer>> hashingFindSubarrays(int[] array){
        List<MutablePair<Integer, Integer>> pairs = new ArrayList<>();

        // create an empty multimap to store ending index of all sub-arrays having same sum
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        // insert (0, -1) pair into the map to handle the case when sub-array with 0 sum starts from index 0
        insertMap(map, 0, -1);

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            // sum = array.sum[0, i]
            sum += array[i];

            // if sum is seen before, there exists at least one sub-array with 0 sum
            if (map.containsKey(sum)){
                for (int start: map.get(sum))
                    pairs.add(new MutablePair<>(start + 1, i));

            }

            // insert (current sum, current index) pair into the multimap
            insertMap(map, sum, i);
        }

        return pairs;
    }
}
