package algorithms;


import algorithms.sorting.SortingUtility;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Algorithms {
    private Algorithms(){
    }

    /*
     Non-modifying sequence operations
     */

    public static boolean allOf(int[] array, int first, int last, Predicate<Integer> predicate){
        return findIfNot(array, first, last, predicate) == -1;
    }

    public static boolean allOf(int[] array, Predicate<Integer> predicate){
        return allOf(array, 0, array.length, predicate);
    }

    public static boolean anyOf(int[] array, int first, int last, Predicate<Integer> predicate){
        return findIf(array, first, last, predicate) != -1;
    }

    public static boolean anyOf(int[] array, Predicate<Integer> predicate){
        return anyOf(array, 0, array.length, predicate);
    }

    public static boolean noneOf(int[] array, int first, int last, Predicate<Integer> predicate){
        return findIf(array, first, last, predicate) == -1;
    }

    public static boolean noneOf(int[] array, Predicate<Integer> predicate){
        return noneOf(array, 0, array.length, predicate);
    }

    public static void forEach(int[] array, int first, int last, Function<Integer, Integer> function){
        forEachN(array, first, last, array.length, function);
    }

    public static void forEach(int[] array, Function<Integer, Integer> function){
        forEach(array, 0, array.length, function);
    }

    public static void forEachN(int[] array, int first, int last, int n, Function<Integer, Integer> function){
        for (int i = 0; i < n && first != last; ++first, ++i)
            array[first] = function.apply(array[first]);
    }

    public static void forEachN(int[] array, int n, Function<Integer, Integer> function){
        forEachN(array, 0, array.length, n, function);
    }

    public static int count(int[] array, int first, int last, int value){
        return countIf(array, first, last, x -> x == value);
    }

    public static int count(int[] array, int value){
        return countIf(array, 0, array.length, x -> x == value);
    }

    public static int countIf(int[] array, Predicate<Integer> predicate){
        return countIf(array, 0, array.length, predicate);
    }

    public static int countIf(int[] array, int first, int last, Predicate<Integer> predicate){
        int count = 0;

        for (; first != last; ++first){
            if (predicate.test(array[first]))
                count++;
        }

        return count;
    }

    public static boolean equalRanges(int[] array1, int first1, int last1, int[] array2, int first2){
        return equalRanges(array1, first1, last1, array2, first2, Objects::equals);
    }

    public static boolean equalRanges(int[] array1, int first1, int last1, int[] array2, int first2,
                                BiPredicate<Integer, Integer> predicate){
        if (array1.length == array2.length)
            return false;

        for (; first1 != last1; ++first1, ++first2){
            if (!predicate.test(array1[first1], array2[first2]))
                return false;
        }

        return true;
    }

    public static int find(int[] array, int first, int last, int value){
        return findIf(array, first, last, x -> x == value);
    }

    public static int find(int[] array, int value){
        return findIf(array, 0, array.length, x -> x == value);
    }

    public static int findIf(int[] array, Predicate<Integer> predicate){
        return findIf(array, 0, array.length, predicate);
    }

    public static int findIfNot(int[] array, int first, int last, Predicate<Integer> predicate){
        return findIf(array, first, last, predicate.negate());
    }

    public static int findIfNot(int[] array, Predicate<Integer> predicate){
        return findIf(array, 0, array.length, predicate.negate());
    }

    public static int findIf(int[] array, int first, int last, Predicate<Integer> predicate){
        for (; first != last; ++first){
            if (predicate.test(array[first]))
                return first;
        }

        return -1;
    }

    // Fisher–Yates shuffle
    public static void shuffle(int[] a) {
        Random rnd = new Random();

        for (int i = a.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);

            // Simple swap
            int t = a[index];
            a[index] = a[i];
            a[i] = t;
        }
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static <E> void swap(E[] a, int i, int j) {
        E t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static int maxElementPos(int[] a){
        int pos = 0;

        for (int i = 1; i < a.length; i++)
            if (a[i] > a[pos])
                pos = i;

        return pos;
    }


    public static int maxElement(int[] a){
        return a[maxElementPos(a)];
    }

    public static int maxElementPos(int[] a, Comparator<Integer> comparator){
        int pos = 0;

        for (int i = 1; i < a.length; i++)
            if (comparator.compare(a[i], a[pos]) > 0)
                pos = i;

        return pos;
    }


    public static int maxElement(int[] a, Comparator<Integer> comparator){
        return a[maxElementPos(a, comparator)];
    }


    public static int minElementPos(int[] a){
        int pos = 0;

        for (int i = 1; i < a.length; i++)
            if (a[i] < a[pos])
                pos = i;

        return pos;
    }

    public static int minElement(int[] a){
        return a[minElementPos(a)];
    }

    public static int minElementPos(int[] a, Comparator<Integer> comparator){
        int pos = 0;

        for (int i = 1; i < a.length; i++)
            if (comparator.compare(a[i], a[pos]) < 0)
                pos = i;

        return pos;
    }

    public static int minElement(int[] a, Comparator<Integer> comparator){
        return a[minElementPos(a, comparator)];
    }

    public static void reverse(int[] a){
        reverse(a, 0, a.length - 1);
    }

    public static void reverse(int[] a, int i, int j){
        while (i < j){
            Algorithms.swap(a, i, j);
            i++; j--;
        }
    }

    public static void reverseGeneral(int[] a, int i, int j){
        if (i > j){
            int t = i;
            i = j;
            j = t;
        }
        
        while (i < j){
            Algorithms.swap(a, i, j);
            i++; j--;
        }
    }

    public static void partialSum(int[] sum){
        partialSum(sum, 0, sum.length);
    }

    public static void partialSum(int[] sum, int fromIndex, int toIndex){
        for (int i = fromIndex + 1; i < toIndex; i++)
            sum[i] += sum[i - 1];
    }

    public static void partialSum(int[] sum, int initValue){
        partialSum(sum, 0, sum.length, initValue);
    }

    public static void partialSum(int[] sum, int fromIndex, int toIndex, int initValue){
        sum[fromIndex] = initValue;
        
        for (int i = fromIndex + 1; i < toIndex; i++)
            sum[i] += sum[i - 1];
    }

    public static <E extends Comparable<? super E>> int partition(E[] a, int fromIndex, int toIndex, int pivot) {
        if (fromIndex == toIndex || fromIndex + 1 == toIndex)
            return fromIndex;

        Algorithms.swap(a, fromIndex, pivot);

        int lhs = fromIndex + 1;
        int rhs = toIndex - 1;

        while (true){
            while (lhs < rhs && a[rhs].compareTo(a[fromIndex]) >= 0)
                --rhs;

            while (lhs < rhs && a[lhs].compareTo(a[fromIndex]) < 0)
                ++lhs;

            if (lhs == rhs)
                break;

            Algorithms.swap(a, lhs, rhs);
        }

        if (SortingUtility.less(a[fromIndex], a[lhs]))
            return fromIndex;

        Algorithms.swap(a, fromIndex, lhs);
        return lhs;
    }

    public static <E extends Comparable<? super E>> int partition(E[] a, int fromIndex, int toIndex, Random random) {
        return partition(a, fromIndex, toIndex, fromIndex + random.nextInt(toIndex - fromIndex));
    }

    public static <E extends Comparable<? super E>> int partition(E[] a, int fromIndex, int toIndex) {
        return partition(a, fromIndex, toIndex, fromIndex);
    }

    public static int partition(int[] a, int fromIndex, int toIndex, int pivot) {
        if (fromIndex == toIndex || fromIndex + 1 == toIndex)
            return fromIndex;

        Algorithms.swap(a, fromIndex, pivot);

        int lhs = fromIndex + 1;
        int rhs = toIndex - 1;

        while (true){
            while (lhs < rhs && !SortingUtility.less(a[rhs], a[fromIndex]))
                --rhs;

            while (lhs < rhs && SortingUtility.less(a[lhs], a[fromIndex]))
                ++lhs;

            if (lhs == rhs)
                break;

            Algorithms.swap(a, lhs, rhs);
        }

        if (SortingUtility.less(a[fromIndex], a[lhs]))
            return fromIndex;

        Algorithms.swap(a, fromIndex, lhs);
        return lhs;
    }

    public static int partition(int[] a, int fromIndex, int toIndex, Random random) {
        return partition(a, fromIndex, toIndex, fromIndex + random.nextInt(toIndex - fromIndex));
    }

    public static int partition(int[] a, int fromIndex, int toIndex) {
        return partition(a, fromIndex, toIndex, fromIndex);
    }
}
