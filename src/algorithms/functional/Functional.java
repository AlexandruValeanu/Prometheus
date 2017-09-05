package algorithms.functional;

import algorithms.functional.interfaces.*;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Contract;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Functional {
    private Functional(){}

    public static byte foldl(ByteBinaryOperator f, byte e, byte... xs){
        if (xs.length == 0)
            return e;
        else{
            for (int i = 0; i < xs.length; i++)
                e = f.applyAsByte(e, xs[i]);

            return e;
        }
    }

    public static boolean foldl(BooleanBinaryOperator f, boolean e, boolean... xs){
        if (xs.length == 0)
            return e;
        else{
            for (int i = 0; i < xs.length; i++)
                e = f.applyAsBoolean(e, xs[i]);

            return e;
        }
    }

    public static char foldl(CharBinaryOperator f, char e, char... xs){
        if (xs.length == 0)
            return e;
        else{
            for (int i = 0; i < xs.length; i++)
                e = f.applyAsChar(e, xs[i]);

            return e;
        }
    }

    public static short foldl(ShortBinaryOperator f, short e, short... xs){
        if (xs.length == 0)
            return e;
        else{
            for (int i = 0; i < xs.length; i++)
                e = f.applyAsShort(e, xs[i]);

            return e;
        }
    }

    public static int foldl(IntBinaryOperator f, int e, int... xs){
        if (xs.length == 0)
            return e;
        else{
            for (int i = 0; i < xs.length; i++)
                e = f.applyAsInt(e, xs[i]);

            return e;
        }
    }

    public static long foldl(LongBinaryOperator f, long e, long... xs){
        if (xs.length == 0)
            return e;
        else{
            for (int i = 0; i < xs.length; i++)
                e = f.applyAsLong(e, xs[i]);

            return e;
        }
    }

    public static float foldl(FloatBinaryOperator f, float e, float... xs){
        if (xs.length == 0)
            return e;
        else{
            for (int i = 0; i < xs.length; i++)
                e = f.applyAsFloat(e, xs[i]);

            return e;
        }
    }

    public static double foldl(DoubleBinaryOperator f, double e, double... xs){
        if (xs.length == 0)
            return e;
        else{
            for (int i = 0; i < xs.length; i++)
                e = f.applyAsDouble(e, xs[i]);

            return e;
        }
    }

    @SafeVarargs
    public static <T, S> S foldl(BiFunction<S, T, S> f, S e, T... xs){
        if (xs.length == 0)
            return e;
        else{
            for (int i = 0; i < xs.length; i++)
                e = f.apply(e, xs[i]);

            return e;
        }
    }

    public static byte foldr(ByteBinaryOperator f, byte e, byte... xs){
        if (xs.length == 0)
            return e;
        else{

            for (int i = xs.length - 1; i >= 0; i--)
                e = f.applyAsByte(e, xs[i]);

            return e;
        }
    }

    public static boolean foldr(BooleanBinaryOperator f, boolean e, boolean... xs){
        if (xs.length == 0)
            return e;
        else{

            for (int i = xs.length - 1; i >= 0; i--)
                e = f.applyAsBoolean(e, xs[i]);

            return e;
        }
    }

    public static char foldr(CharBinaryOperator f, char e, char... xs){
        if (xs.length == 0)
            return e;
        else{

            for (int i = xs.length - 1; i >= 0; i--)
                e = f.applyAsChar(e, xs[i]);

            return e;
        }
    }

    public static short foldr(ShortBinaryOperator f, short e, short... xs){
        if (xs.length == 0)
            return e;
        else{

            for (int i = xs.length - 1; i >= 0; i--)
                e = f.applyAsShort(e, xs[i]);

            return e;
        }
    }

    public static int foldr(IntBinaryOperator f, int e, int... xs){
        if (xs.length == 0)
            return e;
        else{

            for (int i = xs.length - 1; i >= 0; i--)
                e = f.applyAsInt(e, xs[i]);

            return e;
        }
    }

    public static long foldr(LongBinaryOperator f, long e, long... xs){
        if (xs.length == 0)
            return e;
        else{

            for (int i = xs.length - 1; i >= 0; i--)
                e = f.applyAsLong(e, xs[i]);

            return e;
        }
    }

    public static float foldr(FloatBinaryOperator f, float e, float... xs){
        if (xs.length == 0)
            return e;
        else{

            for (int i = xs.length - 1; i >= 0; i--)
                e = f.applyAsFloat(e, xs[i]);

            return e;
        }
    }

    public static double foldr(DoubleBinaryOperator f, double e, double... xs){
        if (xs.length == 0)
            return e;
        else{

            for (int i = xs.length - 1; i >= 0; i--)
                e = f.applyAsDouble(e, xs[i]);

            return e;
        }
    }

    @SafeVarargs
    public static <T, S> S foldr(BiFunction<S, T, S> f, S e, T... xs){
        if (xs.length == 0)
            return e;
        else{
            for (int i = xs.length - 1; i >= 0; i--)
                e = f.apply(e, xs[i]);

            return e;
        }
    }

    @Contract("_, null -> null")
    public static int[] map(IntUnaryOperator f, int... xs){
        if (xs == null)
            return null;

        int[] ys = new int[xs.length];

        for (int i = 0; i < xs.length; i++) {
            ys[i] = f.applyAsInt(xs[i]);
        }

        return ys;
    }

    @Contract("_, null -> null")
    public static long[] map(LongUnaryOperator f, long... xs){
        if (xs == null)
            return null;

        long[] ys = new long[xs.length];

        for (int i = 0; i < xs.length; i++) {
            ys[i] = f.applyAsLong(xs[i]);
        }

        return ys;
    }

    @Contract("_, null -> null")
    public static double[] map(DoubleUnaryOperator f, double... xs){
        if (xs == null)
            return null;

        double[] ys = new double[xs.length];

        for (int i = 0; i < xs.length; i++) {
            ys[i] = f.applyAsDouble(xs[i]);
        }

        return ys;
    }

    @Contract("_, null -> null")
    @SafeVarargs
    public static <T, S> S[] map(Function<T, S> f, T... xs){
        if (xs == null)
            return null;

        @SuppressWarnings("unchecked")
        S[] ys = (S[]) new Object[xs.length];

        for (int i = 0; i < xs.length; i++) {
            ys[i] = f.apply(xs[i]);
        }

        return ys;
    }

    @Contract(value = "_, null -> null", pure = true)
    public static byte[] take(int k, byte... xs){
        return ArrayUtils.subarray(xs, 0, k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static boolean[] take(int k, boolean... xs){
        return ArrayUtils.subarray(xs, 0, k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static char[] take(int k, char... xs){
        return ArrayUtils.subarray(xs, 0, k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static int[] take(int k, int... xs){
        return ArrayUtils.subarray(xs, 0, k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static short[] take(int k, short... xs){
        return ArrayUtils.subarray(xs, 0, k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static long[] take(int k, long... xs){
        return ArrayUtils.subarray(xs, 0, k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static float[] take(int k, float... xs){
        return ArrayUtils.subarray(xs, 0, k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static double[] take(int k, double... xs){
        return ArrayUtils.subarray(xs, 0, k);
    }

    @Contract(value = "_, null -> null", pure = true)
    @SafeVarargs
    public static <T> T[] take(int k, T... xs){
        return ArrayUtils.subarray(xs, 0, k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static byte[] takeRight(int k, byte... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, xs.length - k, xs.length);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static boolean[] takeRight(int k, boolean... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, xs.length - k, xs.length);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static char[] takeRight(int k, char... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, xs.length - k, xs.length);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static short[] takeRight(int k, short... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, xs.length - k, xs.length);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static int[] takeRight(int k, int... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, xs.length - k, xs.length);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static long[] takeRight(int k, long... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, xs.length - k, xs.length);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static float[] takeRight(int k, float... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, xs.length - k, xs.length);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static double[] takeRight(int k, double... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, xs.length - k, xs.length);
    }

    @Contract(value = "_, null -> null", pure = true)
    @SafeVarargs
    public static <T> T[] takeRight(int k, T... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, xs.length - k, xs.length);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static byte[] drop(int k, byte... xs){
        return ArrayUtils.subarray(xs, k, Integer.MAX_VALUE);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static boolean[] drop(int k, boolean... xs){
        return ArrayUtils.subarray(xs, k, Integer.MAX_VALUE);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static char[] drop(int k, char... xs){
        return ArrayUtils.subarray(xs, k, Integer.MAX_VALUE);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static short[] drop(int k, short... xs){
        return ArrayUtils.subarray(xs, k, Integer.MAX_VALUE);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static int[] drop(int k, int... xs){
        return ArrayUtils.subarray(xs, k, Integer.MAX_VALUE);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static long[] drop(int k, long... xs){
        return ArrayUtils.subarray(xs, k, Integer.MAX_VALUE);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static float[] drop(int k, float... xs){
        return ArrayUtils.subarray(xs, k, Integer.MAX_VALUE);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static double[] drop(int k, double... xs){
        return ArrayUtils.subarray(xs, k, Integer.MAX_VALUE);
    }

    @Contract(value = "_, null -> null", pure = true)
    @SafeVarargs
    public static <T> T[] drop(int k, T... xs){
        return ArrayUtils.subarray(xs, k, Integer.MAX_VALUE);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static byte[] dropRight(int k, byte... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, 0, xs.length - k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static boolean[] dropRight(int k, boolean... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, 0, xs.length - k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static char[] dropRight(int k, char... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, 0, xs.length - k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static short[] dropRight(int k, short... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, 0, xs.length - k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static int[] dropRight(int k, int... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, 0, xs.length - k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static long[] dropRight(int k, long... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, 0, xs.length - k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static float[] dropRight(int k, float... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, 0, xs.length - k);
    }

    @Contract(value = "_, null -> null", pure = true)
    public static double[] dropRight(int k, double... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, 0, xs.length - k);
    }

    @Contract(value = "_, null -> null", pure = true)
    @SafeVarargs
    public static <T> T[] dropRight(int k, T... xs){
        if (xs == null)
            return null;

        return ArrayUtils.subarray(xs, 0, xs.length - k);
    }

    // todo: implement all filters - after implementing corresponding streams

    public static int[] filter(IntPredicate p, int... xs){
        return Arrays.stream(xs).filter(p).toArray();
    }

    public static long[] filter(LongPredicate p, long... xs){
        return Arrays.stream(xs).filter(p).toArray();
    }

    public static double[] filter(DoublePredicate p, double... xs){
        return Arrays.stream(xs).filter(p).toArray();
    }

    @SafeVarargs
    public static <T> T[] filter(Predicate<T> p, T... xs){
        @SuppressWarnings("unchecked")
        T[] ys = (T[]) Arrays.stream(xs).filter(p).toArray();
        return ys;
    }

    public static boolean allMatch(IntPredicate p, int... xs){
        return Arrays.stream(xs).allMatch(p);
    }

    public static boolean allMatch(LongPredicate p, long... xs){
        return Arrays.stream(xs).allMatch(p);
    }

    public static boolean allMatch(DoublePredicate p, double... xs){
        return Arrays.stream(xs).allMatch(p);
    }

    @SafeVarargs
    public static <T> boolean allMatch(Predicate<T> p, T... xs){
        return Arrays.stream(xs).allMatch(p);
    }

    public static boolean anyMatch(IntPredicate p, int... xs){
        return Arrays.stream(xs).anyMatch(p);
    }

    public static boolean anyMatch(LongPredicate p, long... xs){
        return Arrays.stream(xs).anyMatch(p);
    }

    public static boolean anyMatch(DoublePredicate p, double... xs){
        return Arrays.stream(xs).anyMatch(p);
    }

    @SafeVarargs
    public static <T> boolean anyMatch(Predicate<T> p, T... xs){
        return Arrays.stream(xs).anyMatch(p);
    }

    // todo: implement all head(s) - after implementing OptionalChar, OptionalChar, ...

    @Contract("!null -> !null")
    public static OptionalInt head(int... xs){
        if (xs == null)
            return OptionalInt.empty();
        else
            return OptionalInt.of(xs[0]);
    }

    @Contract("!null -> !null")
    public static OptionalLong head(long... xs){
        if (xs == null)
            return OptionalLong.empty();
        else
            return OptionalLong.of(xs[0]);
    }

    @Contract("!null -> !null")
    public static OptionalDouble head(double... xs){
        if (xs == null)
            return OptionalDouble.empty();
        else
            return OptionalDouble.of(xs[0]);
    }

    @Contract("!null -> !null")
    @SafeVarargs
    public static <T> Optional<T> head(T... xs){
        if (xs == null)
            return Optional.empty();
        else
            return Optional.of(xs[0]);
    }

    @Contract(value = "null -> null", pure = true)
    public static byte[] tail(byte... xs){
        return drop(1, xs);
    }

    @Contract(value = "null -> null", pure = true)
    public static boolean[] tail(boolean... xs){
        return drop(1, xs);
    }

    @Contract(value = "null -> null", pure = true)
    public static char[] tail(char... xs){
        return drop(1, xs);
    }

    @Contract(value = "null -> null", pure = true)
    public static short[] tail(short... xs){
        return drop(1, xs);
    }

    @Contract(value = "null -> null", pure = true)
    public static int[] tail(int... xs){
        return drop(1, xs);
    }

    @Contract(value = "null -> null", pure = true)
    public static long[] tail(long... xs){
        return drop(1, xs);
    }

    @Contract(value = "null -> null", pure = true)
    public static float[] tail(float... xs){
        return drop(1, xs);
    }

    @Contract(value = "null -> null", pure = true)
    public static double[] tail(double... xs){
        return drop(1, xs);
    }

    // todo: implement all last - after implementing OptionalChar, OptionalChar, ...

    @Contract("!null -> !null")
    public static OptionalInt last(int... xs){
        if (xs == null)
            return OptionalInt.empty();
        else
            return OptionalInt.of(xs[xs.length - 1]);
    }

    @Contract("!null -> !null")
    public static OptionalLong last(long... xs){
        if (xs == null)
            return OptionalLong.empty();
        else
            return OptionalLong.of(xs[xs.length - 1]);
    }

    @Contract("!null -> !null")
    public static OptionalDouble last(double... xs){
        if (xs == null)
            return OptionalDouble.empty();
        else
            return OptionalDouble.of(xs[xs.length - 1]);
    }

    @Contract("!null -> !null")
    @SafeVarargs
    public static <T> Optional<T> last(T... xs){
        if (xs == null)
            return Optional.empty();
        else
            return Optional.of(xs[xs.length - 1]);
    }

    public static OptionalInt max(int... xs){
        return Arrays.stream(xs).max();
    }

    public static OptionalInt max(Comparator<Integer> comp, int... xs){
        Optional<Integer> opt = Stream.of(ArrayUtils.toObject(xs)).max(comp);
        return opt.map(OptionalInt::of).orElseGet(OptionalInt::empty);
    }

    public static OptionalLong max(long... xs){
        return Arrays.stream(xs).max();
    }

    public static OptionalLong max(Comparator<Long> comp, long... xs){
        Optional<Long> opt = Stream.of(ArrayUtils.toObject(xs)).max(comp);
        return opt.map(OptionalLong::of).orElseGet(OptionalLong::empty);
    }

    public static OptionalDouble max(double... xs){
        return Arrays.stream(xs).max();
    }

    public static OptionalDouble max(Comparator<Double> comp, double... xs){
        Optional<Double> opt = Stream.of(ArrayUtils.toObject(xs)).max(comp);
        return opt.map(OptionalDouble::of).orElseGet(OptionalDouble::empty);
    }

    @SafeVarargs
    public static <T> Optional<T> max(Comparator<T> comp, T... xs){
        return Stream.of(xs).max(comp);
    }

    @SafeVarargs
    public static <T> Optional<T> max(T... xs){
        return Arrays.stream(xs).max(null);
    }

    public static OptionalInt min(int... xs){
        return Arrays.stream(xs).min();
    }

    public static OptionalInt min(Comparator<Integer> comp, int... xs){
        Optional<Integer> opt = Stream.of(ArrayUtils.toObject(xs)).min(comp);
        return opt.map(OptionalInt::of).orElseGet(OptionalInt::empty);
    }

    public static OptionalLong min(long... xs){
        return Arrays.stream(xs).min();
    }

    public static OptionalLong min(Comparator<Long> comp, long... xs){
        Optional<Long> opt = Stream.of(ArrayUtils.toObject(xs)).min(comp);
        return opt.map(OptionalLong::of).orElseGet(OptionalLong::empty);
    }

    public static OptionalDouble min(double... xs){
        return Arrays.stream(xs).min();
    }

    public static OptionalDouble min(Comparator<Double> comp, double... xs){
        Optional<Double> opt = Stream.of(ArrayUtils.toObject(xs)).min(comp);
        return opt.map(OptionalDouble::of).orElseGet(OptionalDouble::empty);
    }

    @SafeVarargs
    public static <T> Optional<T> min(T... xs){
        return Arrays.stream(xs).min(null);
    }

    @SafeVarargs
    public static <T> Optional<T> min(Comparator<T> comp, T... xs){
        return Arrays.stream(xs).min(comp);
    }


}
