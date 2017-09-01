package algorithms.sorting;

import algorithms.AlgorithmsOnRanges;

//todo: implement
//todo: example + description of algorithm
public class BubbleSort {
    private BubbleSort(){
    }

    public static void sort(int[] a){
        int n = a.length;

        do{
            int newn = 0;

            for (int i = 1; i < n; i++) {
                if (SortingUtility.less(a[i], a[i - 1])){
                    AlgorithmsOnRanges.swap(a, i - 1, i);
                    newn = i;
                }
            }

            n = newn;

        } while (n > 0);
    }
}
