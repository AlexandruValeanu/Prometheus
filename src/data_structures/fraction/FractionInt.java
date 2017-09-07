package data_structures.fraction;

import algorithms.number_theory.GreatestCommonDivisor;
import org.jetbrains.annotations.NotNull;

public class FractionInt extends Number implements Comparable<FractionInt> {

    /**
     * <code>FractionInt</code> representation of 0.
     */
    public static final FractionInt ZERO = new FractionInt(0, 1);
    /**
     * <code>FractionInt</code> representation of 1.
     */
    public static final FractionInt ONE = new FractionInt(1, 1);
    /**
     * <code>FractionInt</code> representation of 1/2.
     */
    public static final FractionInt ONE_HALF = new FractionInt(1, 2);
    /**
     * <code>FractionInt</code> representation of 1/3.
     */
    public static final FractionInt ONE_THIRD = new FractionInt(1, 3);
    /**
     * <code>FractionInt</code> representation of 2/3.
     */
    public static final FractionInt TWO_THIRDS = new FractionInt(2, 3);
    /**
     * <code>FractionInt</code> representation of 1/4.
     */
    public static final FractionInt ONE_QUARTER = new FractionInt(1, 4);
    /**
     * <code>FractionInt</code> representation of 2/4.
     */
    public static final FractionInt TWO_QUARTERS = new FractionInt(2, 4);
    /**
     * <code>FractionInt</code> representation of 3/4.
     */
    public static final FractionInt THREE_QUARTERS = new FractionInt(3, 4);
    /**
     * <code>FractionInt</code> representation of 1/5.
     */
    public static final FractionInt ONE_FIFTH = new FractionInt(1, 5);
    /**
     * <code>FractionInt</code> representation of 2/5.
     */
    public static final FractionInt TWO_FIFTHS = new FractionInt(2, 5);
    /**
     * <code>FractionInt</code> representation of 3/5.
     */
    public static final FractionInt THREE_FIFTHS = new FractionInt(3, 5);
    /**
     * <code>FractionInt</code> representation of 4/5.
     */
    public static final FractionInt FOUR_FIFTHS = new FractionInt(4, 5);

    /**
     * The numerator number part of the fraction (the three in three sevenths).
     */
    private final int numerator;
    /**
     * The denominator number part of the fraction (the seven in three sevenths).
     */
    private final int denominator;

    /**
     * <p>Constructs a <code>Fraction</code> instance with the 2 parts
     * of a fraction X/Y.</p>
     *
     * @param numerator  the numerator
     * @param denominator  the denominator
     */
    private FractionInt(int numerator, int denominator) {
        super();
        int gcd = GreatestCommonDivisor.gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public static FractionInt valueOf(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }

        if (denominator < 0) {
            if (numerator == Integer.MIN_VALUE || denominator == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: can't negate");
            }

            numerator = -numerator;
            denominator = -denominator;
        }

        return new FractionInt(numerator, denominator);
    }

    public static FractionInt valueOf(int whole, int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }

        if (denominator < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        }

        if (numerator < 0) {
            throw new ArithmeticException("The numerator must not be negative");
        }

        int numeratorValue;

        if (whole < 0) {
            numeratorValue = Math.multiplyExact(whole, denominator) - numerator;
        } else {
            numeratorValue = Math.multiplyExact(whole, denominator) + numerator;
        }

        return new FractionInt(numeratorValue, denominator);
    }

    public static FractionInt valueOf(@NotNull String fraction){
        // todo: implement
        return null;
    }

    @Override
    public int compareTo(@NotNull FractionInt o) {
        return 0;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
