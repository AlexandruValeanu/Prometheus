package algorithms.sorting;

import algorithms.Algorithms;

import java.util.Arrays;

//todo: example + description of algorithm
public class CountingSort {
    private CountingSort(){}

    public static void sort(int a[]){
        final int MAX_V = Algorithms.maxElement(a);
        int[] c = new int[MAX_V + 1];
        int[] b = new int[a.length];

        sort(a, b, c, MAX_V);
    }

    public static void sort(int a[], int b[], int c[], int MAX_V) {
        final int N = a.length;

        Arrays.fill(c, 0, MAX_V + 1, 0);

        for (int x : a) c[x]++;

        Algorithms.partialSum(c, 0, MAX_V + 1);

        for (int i = N - 1; i >= 0; i--)
            b[--c[a[i]]] = a[i];

        System.arraycopy(b, 0, a, 0, N);
    }
}
