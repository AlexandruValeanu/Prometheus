package algorithms.sorting;

import algorithms.arrays.ArrayAlgorithms;

public class RadixSortStringsMSD {
    private RadixSortStringsMSD(){}

    private static final int RADIX = 128;
    private static final int CUT_OFF = 20;
    private static String[] aux;

    public static void sort(String[] array){
        final int N = array.length;
        aux = new String[N];
        sort(array, 0, N - 1, 0);
    }

    private static int charAt(String s, int d){
        if (d < s.length())
            return s.charAt(d);
        else
            return -1;
    }

    private static void swap(String[] array, int x, int y){
        String s = array[x];
        array[x] = array[y];
        array[y] = s;
    }

    private static boolean less(String u, String v, int d){
        return u.substring(d).compareTo(v.substring(d)) < 0;
    }

    private static void insertionSort(String[] array, int lo, int hi, int d){
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(array[j], array[j - 1], d); j--)
                swap(array, j, j - 1);
    }

    private static void sort(String[] array, int lo, int hi, int d){
        if (lo + CUT_OFF >= hi)
            insertionSort(array, lo, hi, d);
        else{
            int[] count = new int[RADIX + 2];

            for (int i = lo; i <= hi; i++)
                count[charAt(array[i], d) + 2]++;

            ArrayAlgorithms.partialSum(count, 0, RADIX + 2);

            for (int i = lo; i <= hi; i++)
                aux[count[charAt(array[i], d) + 1]++] = array[i];

            System.arraycopy(aux, 0, array, lo, hi + 1 - lo);

            for (int i = 0; i < RADIX; i++)
                sort(array, lo + count[i], lo + count[i + 1] - 1, d + 1);
        }
    }
}
