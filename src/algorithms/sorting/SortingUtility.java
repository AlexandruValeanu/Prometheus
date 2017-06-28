package algorithms.sorting;

import org.jetbrains.annotations.Contract;

public class SortingUtility {
    private SortingUtility(){
    }

    public static boolean less(int x, int y){
        return x < y;
    }

    @SuppressWarnings("unchecked expression")
    public static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    @Contract(value = "null -> true", pure = true)
    public static boolean isSorted(int[] array) {
        return array == null || isSorted(array, 0, array.length);

    }

    @Contract(value = "null, _, _ -> true", pure = true)
    public static boolean isSorted(int[] array, int fromIndex, int toIndex){
        if (array == null)
            return true;

        for (int i = fromIndex; i + 1 < toIndex; i++) {
            if (array[i] > array[i + 1])
                return false;
        }

        return true;
    }
}
