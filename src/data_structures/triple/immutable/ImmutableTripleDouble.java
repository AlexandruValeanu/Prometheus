package data_structures.triple.immutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class ImmutableTripleDouble implements Comparable<ImmutableTripleDouble> {
    public final double first;
    public final double second;
    public final double third;

    public ImmutableTripleDouble() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public ImmutableTripleDouble(double first, double second, double third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public double getFirst() {
        return first;
    }

    public double getSecond() {
        return second;
    }

    public double getThird() {
        return third;
    }

    @Override
    public int compareTo(@NotNull ImmutableTripleDouble o) {
        return Comparator.comparing(ImmutableTripleDouble::getFirst)
                .thenComparing(ImmutableTripleDouble::getSecond)
                .thenComparing(ImmutableTripleDouble::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTripleDouble that = (ImmutableTripleDouble) o;
        return first == that.first &&
                second == that.second &&
                third == that.third;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return "ImmutableTripleFloat{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
