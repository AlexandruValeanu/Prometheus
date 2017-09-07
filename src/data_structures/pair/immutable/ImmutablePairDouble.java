package data_structures.pair.immutable;

import data_structures.pair.mutable.PairDouble;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

final public class ImmutablePairDouble implements Comparable<ImmutablePairDouble> {
    public final double first;
    public final double second;

    public ImmutablePairDouble() {
        this.first = 0;
        this.second = 0;
    }

    public ImmutablePairDouble(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public ImmutablePairDouble(PairDouble pairDouble) {
        this.first = pairDouble.first;
        this.second = pairDouble.second;
    }

    public ImmutablePairDouble(ImmutablePairDouble pairDouble) {
        this.first = pairDouble.first;
        this.second = pairDouble.second;
    }

    public double getFirst() {
        return first;
    }

    public double getSecond() {
        return second;
    }

    @Override
    public int compareTo(@NotNull ImmutablePairDouble o) {
        return Comparator.comparing(ImmutablePairDouble::getFirst)
                .thenComparing(ImmutablePairDouble::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutablePairDouble pair = (ImmutablePairDouble) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "ImmutablePairDouble{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static ImmutablePairDouble valueOf(double first, double second) {
        return new ImmutablePairDouble(first, second);
    }
}
