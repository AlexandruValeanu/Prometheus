package algorithms.sorting;

//todo: example + description of algorithm
public class InsertionSort {
    private InsertionSort(){
    }

    public static void sort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int j;
            int temp = a[i];

            for (j = i - 1; j >= 0 && SortingUtility.less(temp, a[j]); j--){
                a[j + 1] = a[j];
            }

            a[j + 1] = temp;
        }
    }
}
