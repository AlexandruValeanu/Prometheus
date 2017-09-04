package algorithms.sorting;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;

import static algorithms.arrays.ArrayAlgorithms.partition;

//todo: test + explain
public class QuickSelect {
    private QuickSelect(){}

    private static Random random = new Random();

    public static <E extends Comparable<? super E>> Optional<E> nthElement(E[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int pivotIndex = partition(arr, left, right + 1, random);

            if (pivotIndex == k) {
                return Optional.of(arr[pivotIndex]);
            } else if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return Optional.empty();
    }

    public static OptionalInt nthElement(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int pivotIndex = partition(arr, left, right + 1, random);

            if (pivotIndex == k) {
                return OptionalInt.of(arr[pivotIndex]);
            } else if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return OptionalInt.empty();
    }
}
