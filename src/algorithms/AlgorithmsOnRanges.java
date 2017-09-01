package algorithms;


import algorithms.sorting.SortingUtility;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.function.*;

public class AlgorithmsOnRanges {
    private AlgorithmsOnRanges(){
    }

    public static int findIf(int[] array, int from, int to, IntPredicate predicate){
        for (; from < to; ++from){
            if (predicate.test(array[from]))
                return from;
        }

        return -1;
    }

    public static int findIf(int[] array, IntPredicate predicate){
        return findIf(array, 0, array.length, predicate);
    }

    public static int find(int[] array, int from, int to, int value){
        return findIf(array, from, to, x -> x == value);
    }

    public static int find(int[] array, int value){
        return findIf(array, 0, array.length, x -> x == value);
    }

    public static int findIfNot(int[] array, int from, int to, IntPredicate predicate){
        return findIf(array, from, to, predicate.negate());
    }

    public static int findIfNot(int[] array, IntPredicate predicate){
        return findIf(array, 0, array.length, predicate.negate());
    }

    public static boolean allOf(int[] array, int from, int to, IntPredicate predicate){
        return findIfNot(array, from, to, predicate) == -1;
    }

    public static boolean allOf(int[] array, IntPredicate predicate){
        return allOf(array, 0, array.length, predicate);
    }

    public static boolean anyOf(int[] array, int from, int to, IntPredicate predicate){
        return findIf(array, from, to, predicate) != -1;
    }

    public static boolean anyOf(int[] array, IntPredicate predicate){
        return anyOf(array, 0, array.length, predicate);
    }

    public static boolean noneOf(int[] array, int from, int to, IntPredicate predicate){
        return findIf(array, from, to, predicate) == -1;
    }

    public static boolean noneOf(int[] array, IntPredicate predicate){
        return noneOf(array, 0, array.length, predicate);
    }

    public static void forEachN(int[] array, int from, int to, int n, IntUnaryOperator function){
        for (int i = 0; i < n && from < to; ++from, ++i)
            array[from] = function.applyAsInt(array[from]);
    }

    public static void forEachN(int[] array, int n, IntUnaryOperator function){
        forEachN(array, 0, array.length, n, function);
    }

    public static void forEach(int[] array, int from, int to, IntUnaryOperator function){
        forEachN(array, from, to, array.length, function);
    }

    public static void forEach(int[] array, IntUnaryOperator function){
        forEach(array, 0, array.length, function);
    }

    public static int countIf(int[] array, int from, int to, IntPredicate predicate){
        int count = 0;

        for (; from < to; ++from){
            if (predicate.test(array[from]))
                count++;
        }

        return count;
    }

    public static int countIf(int[] array, IntPredicate predicate){
        return countIf(array, 0, array.length, predicate);
    }

    public static int count(int[] array, int from, int to, int value){
        return countIf(array, from, to, x -> x == value);
    }

    public static int count(int[] array, int value){
        return countIf(array, 0, array.length, x -> x == value);
    }

    public static boolean equalRanges(int[] array1, int from1, int len, int[] array2, int from2){
        return equalRanges(array1, from1, len, array2, from2, Objects::equals);
    }

    public static boolean equalRanges(int[] array1, int from1, int len, int[] array2, int from2,
                                BiPredicate<Integer, Integer> predicate){
        for (int i = 0; i < len; i++){
            if (!predicate.test(array1[from1 + i], array2[from2 + i]))
                return false;
        }

        return true;
    }

    public static void copy(int[] source, int fromSrc, int len, int[] dest, int fromDest){
        for (int i = 0; i < len; i++)
            dest[fromDest + i] = source[fromSrc + i];
    }

    public static void copy(int[] source, int[] dest){
        copy(source, 0, source.length, dest, 0);
    }

    // Fisher–Yates shuffle
    public static void shuffle(int[] a) {
        shuffle(a, new Random());
    }

    // Fisher–Yates shuffle
    public static void shuffle(int[] a, Random rnd) {

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

    public static int maxElementPos(int[] a, int from, int to){
        assert from < to;

        int pos = from;

        for (int i = from + 1; i < to; i++) {
            if (a[i] > a[pos])
                pos = i;
        }

        return pos;
    }

    public static int maxElementPos(int[] a){
        return maxElementPos(a, 0, a.length);
    }


    public static int maxElement(int[] a){
        return a[maxElementPos(a)];
    }

    public static int maxElement(int[] a, int from, int to){
        return a[maxElementPos(a, from, to)];
    }

    public static int maxElementPos(int[] a, int from, int to, Comparator<Integer> comparator){
        assert from < to;

        int pos = from;

        for (int i = from + 1; i < to; i++)
            if (comparator.compare(a[i], a[pos]) > 0)
                pos = i;

        return pos;
    }


    public static int maxElement(int[] a, Comparator<Integer> comparator){
        return a[maxElementPos(a, 0, a.length, comparator)];
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
            AlgorithmsOnRanges.swap(a, i, j);
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
            AlgorithmsOnRanges.swap(a, i, j);
            i++; j--;
        }
    }

    public static void partialSum(int[] sum){
        partialSum(sum, 0, sum.length);
    }

    public static void partialSum(int[] sum, int from, int to){
        for (int i = from + 1; i < to; i++)
            sum[i] += sum[i - 1];
    }

    public static void partialSum(int[] sum, int initValue){
        partialSum(sum, 0, sum.length, initValue);
    }

    public static void partialSum(int[] sum, int from, int to, int initValue){
        sum[from] = initValue;
        
        for (int i = from + 1; i < to; i++)
            sum[i] += sum[i - 1];
    }

    public static <E extends Comparable<? super E>> int partition(E[] a, int from, int to, int pivot) {
        if (from == to || from + 1 == to)
            return from;

        AlgorithmsOnRanges.swap(a, from, pivot);

        int lhs = from + 1;
        int rhs = to - 1;

        while (true){
            while (lhs < rhs && a[rhs].compareTo(a[from]) >= 0)
                --rhs;

            while (lhs < rhs && a[lhs].compareTo(a[from]) < 0)
                ++lhs;

            if (lhs == rhs)
                break;

            AlgorithmsOnRanges.swap(a, lhs, rhs);
        }

        if (SortingUtility.less(a[from], a[lhs]))
            return from;

        AlgorithmsOnRanges.swap(a, from, lhs);
        return lhs;
    }

    public static <E extends Comparable<? super E>> int partition(E[] a, int from, int to, Random random) {
        return partition(a, from, to, from + random.nextInt(to - from));
    }

    public static <E extends Comparable<? super E>> int partition(E[] a, int from, int to) {
        return partition(a, from, to, from);
    }

    public static int partition(int[] a, int from, int to, int pivot) {
        if (from == to || from + 1 == to)
            return from;

        AlgorithmsOnRanges.swap(a, from, pivot);

        int lhs = from + 1;
        int rhs = to - 1;

        while (true){
            while (lhs < rhs && !SortingUtility.less(a[rhs], a[from]))
                --rhs;

            while (lhs < rhs && SortingUtility.less(a[lhs], a[from]))
                ++lhs;

            if (lhs == rhs)
                break;

            AlgorithmsOnRanges.swap(a, lhs, rhs);
        }

        if (SortingUtility.less(a[from], a[lhs]))
            return from;

        AlgorithmsOnRanges.swap(a, from, lhs);
        return lhs;
    }

    public static int partition(int[] a, int from, int to, Random random) {
        return partition(a, from, to, from + random.nextInt(to - from));
    }

    public static int partition(int[] a, int from, int to) {
        return partition(a, from, to, from);
    }

    public static boolean nextPermutation(int[] a, int from, int to){
        if (from == to || from + 1 == to)
            return false;

        int p = to - 1;

        while (p - 1 >= 0 && !SortingUtility.less(a[p], a[p - 1]))
            p--;

        if (p > 0){
            swap(a, p, p - 1);
            reverse(a, p, to - 1);
            return true;
        }

        return false;
    }
}
