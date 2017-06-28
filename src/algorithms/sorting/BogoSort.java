package algorithms.sorting;

import algorithms.Algorithms;

//todo: example + description of algorithm
public class BogoSort {
    private BogoSort(){}

    // O((n+1)!)
    public static void sort(int[] a){
        do {
            Algorithms.shuffle(a);

        } while (!SortingUtility.isSorted(a));
    }
}
