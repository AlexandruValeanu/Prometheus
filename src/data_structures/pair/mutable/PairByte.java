package data_structures.pair.mutable;

import data_structures.pair.immutable.ImmutablePairByte;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class PairByte implements Comparable<PairByte> {
    public byte first;
    public byte second;

    public PairByte() {
        this.first = 0;
        this.second = 0;
    }

    public PairByte(byte first, byte second) {
        this.first = first;
        this.second = second;
    }

    public PairByte(PairByte pairByte) {
        this.first = pairByte.first;
        this.second = pairByte.second;
    }

    public PairByte(ImmutablePairByte pairByte) {
        this.first = pairByte.first;
        this.second = pairByte.second;
    }

    public byte getFirst() {
        return first;
    }

    public void setFirst(byte first) {
        this.first = first;
    }

    public byte getSecond() {
        return second;
    }

    public void setSecond(byte second) {
        this.second = second;
    }

    @Override
    public int compareTo(@NotNull PairByte o) {
        return Comparator.comparing(PairByte::getFirst)
                .thenComparing(PairByte::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairByte pair = (PairByte) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "PairByte{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static PairByte valueOf(byte first, byte second) {
        return new PairByte(first, second);
    }
}
