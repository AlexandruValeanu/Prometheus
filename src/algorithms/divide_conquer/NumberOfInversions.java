package algorithms.divide_conquer;

import algorithms.arrays.ArrayAlgorithms;

public class NumberOfInversions {
    private NumberOfInversions(){}

    public static long countInversions(int[] array){
        return countInversions(array, 0, array.length);
    }

    public static long countInversions(int[] array, int from, int to){
        if (array == null || from >= to)
            return 0;

        final int n = to - from;
        int[] A = new int[n];
        int[] B = new int[n];

        ArrayAlgorithms.copy(array, from, n, A, 0);

        return mergeSortCount(A, 0, n - 1, B);
    }

    private static long mergeSortCount(int[] A, int lo, int hi, int[] B){
        if (lo == hi)
            return 0;

        int m = (lo + hi) >> 1;
        long inversions = mergeSortCount(A, lo, m, B) + mergeSortCount(A, m + 1, hi, B);

        for (int i = lo, j = m + 1, k = lo; i <= m || j <= hi; )
            if (j > hi || (i <= m && A[i] <= A[j]))
                B[k++] = A[i++];
            else{
                B[k++] = A[j++];
                inversions += m - i + 1;
            }

        System.arraycopy(B, lo, A, lo, hi - lo + 1);
        return inversions;
    }
}
