package algorithms.sorting;

import algorithms.arrays.ArrayAlgorithms;

//todo: example + description of algorithm
public class CocktailSort {
    private CocktailSort(){}

    // bidirectional bubble sort
    public static void sort(int a[]) {
        final int N = a.length;
        int begin = -1;
        int end = N - 2;
        boolean swapped;

        do {
            swapped = false;
            begin++;

            for (int i = begin; i <= end; ++i)
                if (SortingUtility.less(a[i + 1], a[i])) {
                    ArrayAlgorithms.swap(a, i, i + 1);
                    swapped = true;
                }

            if (!swapped)
                break;

            swapped = false;
            end--;

            for (int i = end; i >= begin; i--)
                if (SortingUtility.less(a[i + 1], a[i])) {
                    ArrayAlgorithms.swap(a, i, i + 1);
                    swapped = true;
                }

        } while (swapped);
    }
}
