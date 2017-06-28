package algorithms.sorting;

//todo: example + description of algorithm
public class ShellSort {
    private ShellSort(){
    }

    // Marcin Ciura's gap sequence: 701, 301, 132, 57, 23, 10, 4, 1
    // Complexity: Unknown (experimentally derived sequence)
    private static final int[] gaps = new int[]{701, 301, 132, 57, 23, 10, 4, 1};

    public static void sort(int[] a, int[] gapsSeq){
        // Start with the largest gap and work down to a gap of 1
        for (int gap: gapsSeq){
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already in gapped order
            // keep adding one more element until the entire array is gap sorted
            for (int i = gap; i < a.length; i++) {
                // add a[i] to the elements that have been gap sorted
                // save a[i] in temp and make a hole at position i
                int j, temp = a[i];

                // shift earlier gap-sorted elements up until the correct location for a[i] is found
                for (j = i; j >= gap && SortingUtility.less(temp, a[j - gap]); j -= gap){
                    a[j] = a[j - gap];
                }

                //put temp (the original a[i]) in its correct location
                a[j] = temp;
            }
        }
    }

    public static void sort(int[] a){
        sort(a, gaps);
    }
}
