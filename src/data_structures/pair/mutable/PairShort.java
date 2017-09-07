package data_structures.pair.mutable;

import data_structures.pair.immutable.ImmutablePairLong;
import data_structures.pair.immutable.ImmutablePairShort;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class PairShort implements Comparable<PairShort> {
    public short first;
    public short second;

    public PairShort() {
        this.first = 0;
        this.second = 0;
    }

    public PairShort(short first, short second) {
        this.first = first;
        this.second = second;
    }

    public PairShort(PairShort pairShort) {
        this.first = pairShort.first;
        this.second = pairShort.second;
    }

    public PairShort(ImmutablePairShort pairShort) {
        this.first = pairShort.first;
        this.second = pairShort.second;
    }

    public short getFirst() {
        return first;
    }

    public void setFirst(short first) {
        this.first = first;
    }

    public short getSecond() {
        return second;
    }

    public void setSecond(short second) {
        this.second = second;
    }

    @Override
    public int compareTo(@NotNull PairShort o) {
        return Comparator.comparing(PairShort::getFirst)
                .thenComparing(PairShort::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairShort pair = (PairShort) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "PairShort{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static PairShort valueOf(short first, short second) {
        return new PairShort(first, second);
    }
}
