package data_structures.pair.mutable;

import data_structures.pair.immutable.ImmutablePairDouble;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class PairDouble implements Comparable<PairDouble> {
    public double first;
    public double second;

    public PairDouble() {
        this.first = 0;
        this.second = 0;
    }

    public PairDouble(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public PairDouble(PairDouble pairDouble) {
        this.first = pairDouble.first;
        this.second = pairDouble.second;
    }

    public PairDouble(ImmutablePairDouble pairDouble) {
        this.first = pairDouble.first;
        this.second = pairDouble.second;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    @Override
    public int compareTo(@NotNull PairDouble o) {
        return Comparator.comparing(PairDouble::getFirst)
                .thenComparing(PairDouble::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairDouble pair = (PairDouble) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "PairDouble{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static PairDouble valueOf(double first, double second) {
        return new PairDouble(first, second);
    }
}
