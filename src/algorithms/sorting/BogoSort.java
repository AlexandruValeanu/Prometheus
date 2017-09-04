package algorithms.sorting;

import algorithms.arrays.ArrayAlgorithms;

//todo: example + description of algorithm
public class BogoSort {
    private BogoSort(){}

    // O((n+1)!)
    public static void sort(int[] a){
        do {
            ArrayAlgorithms.shuffle(a);

        } while (!SortingUtility.isSorted(a));
    }
}
