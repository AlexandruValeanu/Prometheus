package algorithms.sorting;

import algorithms.arrays.ArrayAlgorithms;

//todo: example + description of algorithm
public class SelectionSort {
    private SelectionSort(){
    }

    public static void sort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < a.length; j++) {
                if (SortingUtility.less(a[j], a[minPos]))
                    minPos = j;
            }

            if (i != minPos)
                ArrayAlgorithms.swap(a, i, minPos);
        }
    }
}
