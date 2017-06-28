package algorithms.sorting;

import algorithms.Algorithms;

//todo: example + description of algorithm
public class StoogeSort {
    private StoogeSort() {
    }

    public static void sort(int[] a) {
        stoogeSort(a, 0, a.length - 1);
    }

    // O(n^2.7095...)
    private static void stoogeSort(int[] a, int lo, int hi) {
        if (SortingUtility.less(a[hi], a[lo]))
            Algorithms.swap(a, lo, hi);

        int length = hi - lo + 1;

        if (length >= 3) {
            stoogeSort(a, lo, hi - length / 3);
            stoogeSort(a, lo + length / 3, hi);
            stoogeSort(a, lo, hi - length / 3);
        }
    }
}
