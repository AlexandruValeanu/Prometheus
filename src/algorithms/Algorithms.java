package algorithms;


import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Algorithms {
    private Algorithms(){
    }

    /*
     Non-modifying sequence operations
     */

    public static boolean all_of(int[] array, int first, int last, Predicate<Integer> predicate){
        return find_if_not(array, first, last, predicate) == -1;
    }

    public static boolean all_of(int[] array, Predicate<Integer> predicate){
        return all_of(array, 0, array.length, predicate);
    }

    public static boolean any_of(int[] array, int first, int last, Predicate<Integer> predicate){
        return find_if(array, first, last, predicate) != -1;
    }

    public static boolean any_of(int[] array, Predicate<Integer> predicate){
        return any_of(array, 0, array.length, predicate);
    }

    public static boolean none_of(int[] array, int first, int last, Predicate<Integer> predicate){
        return find_if(array, first, last, predicate) == -1;
    }

    public static boolean none_of(int[] array, Predicate<Integer> predicate){
        return none_of(array, 0, array.length, predicate);
    }

    public static void for_each(int[] array, int first, int last, Function<Integer, Integer> function){
        for_each_n(array, first, last, array.length, function);
    }

    public static void for_each(int[] array, Function<Integer, Integer> function){
        for_each(array, 0, array.length, function);
    }

    public static void for_each_n(int[] array, int first, int last, int n, Function<Integer, Integer> function){
        for (int i = 0; i < n && first != last; ++first, ++i)
            array[first] = function.apply(array[first]);
    }

    public static void for_each_n(int[] array, int n, Function<Integer, Integer> function){
        for_each_n(array, 0, array.length, n, function);
    }

    public static int count(int[] array, int first, int last, int value){
        return count_if(array, first, last, x -> x == value);
    }

    public static int count(int[] array, int value){
        return count_if(array, 0, array.length, x -> x == value);
    }

    public static int count_if(int[] array, Predicate<Integer> predicate){
        return count_if(array, 0, array.length, predicate);
    }

    public static int count_if(int[] array, int first, int last, Predicate<Integer> predicate){
        int count = 0;

        for (; first != last; ++first){
            if (predicate.test(array[first]))
                count++;
        }

        return count;
    }

    public static boolean equal(int[] array1, int first1, int last1, int[] array2, int first2){
        return equal(array1, first1, last1, array2, first2, Objects::equals);
    }

    public static boolean equal(int[] array1, int first1, int last1, int[] array2, int first2,
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
        return find_if(array, first, last, x -> x == value);
    }

    public static int find(int[] array, int value){
        return find_if(array, 0, array.length, x -> x == value);
    }

    public static int find_if(int[] array, Predicate<Integer> predicate){
        return find_if(array, 0, array.length, predicate);
    }

    public static int find_if_not(int[] array, int first, int last, Predicate<Integer> predicate){
        return find_if(array, first, last, predicate.negate());
    }

    public static int find_if_not(int[] array, Predicate<Integer> predicate){
        return find_if(array, 0, array.length, predicate.negate());
    }

    public static int find_if(int[] array, int first, int last, Predicate<Integer> predicate){
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
}
