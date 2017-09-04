package algorithms.sorting;

import algorithms.arrays.ArrayAlgorithms;

import java.util.Arrays;
import java.util.OptionalInt;

//todo: http://www.keithschwarz.com/interesting/code/median-of-medians/Selection.hh.html
//todo: copy and modify explanation

public class MedianOfMedians {
    private MedianOfMedians(){}

    public static OptionalInt nthElement(int[] a, int k){
        if (k < 0 || k >= a.length)
            return OptionalInt.empty();

        selection(a, 0, a.length, k);
        return OptionalInt.of(a[k]);
    }

    private static void selection(int[] a, int fromIndex, int toIndex, int k) {
        if (fromIndex == toIndex || fromIndex + 1 == toIndex)
            return;

        int nextMedianPosition = fromIndex;

        int lastBlockStart = fromIndex + ((toIndex - fromIndex) / 5) * 5;
        for (int blockStart = fromIndex; blockStart != lastBlockStart; blockStart += 5, ++nextMedianPosition) {
            /* Sort the block. */
            Arrays.sort(a, blockStart, blockStart + 5);
            ArrayAlgorithms.swap(a, nextMedianPosition, blockStart + 2);
        }

        if (lastBlockStart != toIndex){
            Arrays.sort(a, lastBlockStart, toIndex);
            ArrayAlgorithms.swap(a, nextMedianPosition, lastBlockStart + (toIndex - lastBlockStart) / 2);

            ++nextMedianPosition;
        }

        int medianOfMedians = fromIndex + (nextMedianPosition - fromIndex) / 2;
        selection(a, fromIndex, nextMedianPosition, medianOfMedians);

        ArrayAlgorithms.swap(a, medianOfMedians, fromIndex);
        int crossoverPoint = ArrayAlgorithms.partition(a, fromIndex, toIndex);

        if (crossoverPoint == k) {
            // nothing left to be done
        }
        else if (crossoverPoint > k)
            selection(a, fromIndex, crossoverPoint, k);
        else
            selection(a, crossoverPoint, toIndex, k);
    }
}
