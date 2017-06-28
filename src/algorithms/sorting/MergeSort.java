package algorithms.sorting;

//todo: example + description of algorithm
public class MergeSort {
    private MergeSort(){
    }

    public enum TypeOfMergeSort{
        TOP_DOWN, BOTTOM_UP
    }

    private static int[] aux = null;
    private static Comparable[] auxC = null;

    private static void merge(int[] a, int lo, int mid, int hi) {
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) { // Copy a[lo..hi] to aux[lo..hi]
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) { // Merge back to a[lo..hi]
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (SortingUtility.less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    public static void sort(int[] a, TypeOfMergeSort type){
        if (aux == null || aux.length < a.length)
            aux = new int[a.length];

        if (type == TypeOfMergeSort.TOP_DOWN)
            topDownMergeSort(a, 0, a.length - 1);
        else
            bottomUpMergeSort(a);
    }

    private static void topDownMergeSort(int[] a, int lo, int hi) {
        // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        topDownMergeSort(a, lo, mid);      // Sort left half.
        topDownMergeSort(a, mid+1, hi); // Sort right half.
        merge(a, lo, mid, hi); // Merge results (code on page 271).
    }

    private static void bottomUpMergeSort(int[] a){
        // Do lg N passes of pairwise merges.
        final int N = a.length;

        for (int sz = 1; sz < N; sz = 2 * sz) {
            for (int lo = 0; lo + sz < N; lo += 2 * sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
            }
        }
    }
}
