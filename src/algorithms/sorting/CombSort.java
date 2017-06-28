package algorithms.sorting;

import algorithms.Algorithms;

//todo: example + description of algorithm
public class CombSort {
    private CombSort(){}

    public static void sort(int[] a){
        final int N = a.length;
        int gap = N;
        double shrink = 1.3;
        boolean swapped = true;

        while (gap > 1 || swapped) {
            gap = (int)(1.0 * gap / shrink);

            if (gap < 1)
                gap = 1;

            int i = 0;
            swapped = false;

            while (i + gap < N) {
                if (SortingUtility.less(a[i + gap], a[i])) {
                    Algorithms.swap(a, i, i + gap);
                    swapped = true;
                }

                i++;
            }
        }
    }
}
