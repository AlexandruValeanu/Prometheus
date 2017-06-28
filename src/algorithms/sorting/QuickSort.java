package algorithms.sorting;

import algorithms.Algorithms;

//todo: example + description of algorithm
public class QuickSort {
    private QuickSort(){
    }

    public static void sort(int[] a){
        Algorithms.shuffle(a);
        quickSort(a, 0, a.length - 1);
    }

    public static void sort3way(int[] a){
        Algorithms.shuffle(a);
        quickSort3way(a, 0, a.length - 1);
    }

    private static int partition(int[] a, int lo, int hi) {
        // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi + 1; // left and right scan indices
        int v = a[lo];          // partitioning item (pivot)

        do {
            // Scan right, scan left, check for scan complete, and exchange.
            while (SortingUtility.less(a[++i], v)) if (i == hi) break;
            while (SortingUtility.less(v, a[--j])) if (j == lo) break;

            Algorithms.swap(a, i, j);

        } while (i < j);

        Algorithms.swap(a, lo, j); // Put v = a[j] into position

        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (hi <= lo) return;

        int j = partition(a, lo, hi); // Partition (see page 291).

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
                Algorithms.swap(a, lt++, i++);
            else if (cmp > 0)
                Algorithms.swap(a, i, gt--);
            else
                i++;
        }

        // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        quickSort3way(a, lo, lt - 1);
        quickSort3way(a, gt + 1, hi);
    }
}
