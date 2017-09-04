package algorithms.sorting;

import algorithms.arrays.ArrayAlgorithms;

import java.util.Arrays;

public class RadixSortStringsLSD {
    private RadixSortStringsLSD(){}

    static void sort(String[] array, int W){
        final int N = array.length;
        final int RADIX = 128;

        String[] aux = new String[N];
        int[] count = new int[RADIX + 1];

        for (int d = W - 1; d >= 0; d--) {

            for (String anArray : array) count[anArray.charAt(d) + 1]++;

            ArrayAlgorithms.partialSum(count, 0, RADIX + 1);

            for (String anArray : array) aux[count[anArray.charAt(d)]++] = anArray;

            System.arraycopy(aux, 0, array, 0, N);
            Arrays.fill(count, 0);
        }
    }
}
