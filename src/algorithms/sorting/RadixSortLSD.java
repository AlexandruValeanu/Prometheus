package algorithms.sorting;

import algorithms.AlgorithmsOnRanges;

import java.util.Arrays;

//todo: example + description of algorithm
public class RadixSortLSD {
    private RadixSortLSD() {
    }

    final public static int MAX_BITS = 32;
    final public static int MAX_CHUNKS = 2;
    final public static int RADIX = 1 << (MAX_BITS / MAX_CHUNKS);

    private static int[] auxC = null;

    public static void sort(int[] a){
        if (auxC == null)
            auxC = new int[RADIX + 1];

        int[] b = new int[a.length];

        sort(a, b, auxC);
    }

    public static void sort(int[] a, int[] b, int[] c){
        final int step = MAX_BITS / MAX_CHUNKS;
        final int mask = RADIX - 1;

        for (int d = 0, shift = 0; d < MAX_CHUNKS; d++, shift += step) {
            Arrays.fill(c, 0, RADIX, 0);

            for (int x: a)
                ++c[(x >> shift) & mask];

            AlgorithmsOnRanges.partialSum(c, 0, RADIX + 1);

            for (int i = a.length - 1; i >= 0; i--) {
                b[--c[(a[i] >> shift) & mask]] = a[i];
            }

            System.arraycopy(b, 0, a, 0, a.length);
        }
    }
}