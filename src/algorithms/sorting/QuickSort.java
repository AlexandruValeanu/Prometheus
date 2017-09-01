package algorithms.sorting;

import algorithms.AlgorithmsOnRanges;

import java.util.Random;

//todo: example + description of algorithm
public class QuickSort {
    private QuickSort(){
    }

    private static Random random = new Random();

    public static void sort(int[] a){
        AlgorithmsOnRanges.shuffle(a);
        quickSort(a, 0, a.length - 1);
    }

    public static void sort3way(int[] a){
        AlgorithmsOnRanges.shuffle(a);
        quickSort3way(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (hi <= lo) return;

        int j = AlgorithmsOnRanges.partition(a, lo, hi + 1, random);

        quickSort(a, lo, j - 1); // Sort left part a[lo .. j-1].
        quickSort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
    }

    private static void quickSort3way(int[] a, int lo, int hi) {
        if (hi <= lo) return;

        int lt = lo, i = lo + 1, gt = hi;
        int v = a[lo];

        while (i <= gt) {
            int cmp = Integer.compare(a[i], v);

            if (cmp < 0)
                AlgorithmsOnRanges.swap(a, lt++, i++);
            else if (cmp > 0)
                AlgorithmsOnRanges.swap(a, i, gt--);
            else
                i++;
        }

        // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        quickSort3way(a, lo, lt - 1);
        quickSort3way(a, gt + 1, hi);
    }
}
