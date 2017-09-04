package algorithms.sorting;

import algorithms.arrays.ArrayAlgorithms;

//todo: example + description of algorithm
public class HeapSort {
    private HeapSort(){
    }

    public static void sort(int[] a){
        int n = a.length;
        System.out.println("da " + n);

        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(a, i, n);
        }

        while (n >= 1){
            ArrayAlgorithms.swap(a, 0, n - 1);
            n--;
            sink(a, 0, n);
        }

        ArrayAlgorithms.reverse(a);
    }

    private static void sink(int[] a, int pos, int N) {
        while (2 * pos + 1 < N){
            int j = 2 * pos + 1;
            int rs = 2 * pos + 2;

            if (rs < N && SortingUtility.less(a[rs], a[j]))
                j = rs;

            if (SortingUtility.less(a[j], a[pos])){
                ArrayAlgorithms.swap(a, j, pos);
                pos = j;
            }
            else break;
        }
    }
}
