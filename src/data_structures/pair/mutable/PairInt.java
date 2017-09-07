package data_structures.pair.mutable;

import data_structures.pair.immutable.ImmutablePairInt;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class PairInt implements Comparable<PairInt> {
    public int first;
    public int second;

    public PairInt() {
        this.first = 0;
        this.second = 0;
    }

    public PairInt(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public PairInt(PairInt pairByte) {
        this.first = pairByte.first;
        this.second = pairByte.second;
    }

    public PairInt(ImmutablePairInt pairInt) {
        this.first = pairInt.first;
        this.second = pairInt.second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public int compareTo(@NotNull PairInt o) {
        return Comparator.comparing(PairInt::getFirst)
                .thenComparing(PairInt::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairInt pair = (PairInt) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "PairInt{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static PairInt valueOf(int first, int second) {
        return new PairInt(first, second);
    }
}
