package data_structures.pair.immutable;

import data_structures.pair.mutable.PairByte;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

final public class ImmutablePairByte implements Comparable<ImmutablePairByte> {
    public final byte first;
    public final byte second;

    public ImmutablePairByte() {
        this.first = 0;
        this.second = 0;
    }

    public ImmutablePairByte(byte first, byte second) {
        this.first = first;
        this.second = second;
    }

    public ImmutablePairByte(PairByte pairByte) {
        this.first = pairByte.first;
        this.second = pairByte.second;
    }

    public ImmutablePairByte(ImmutablePairByte pairByte) {
        this.first = pairByte.first;
        this.second = pairByte.second;
    }

    public byte getFirst() {
        return first;
    }

    public byte getSecond() {
        return second;
    }

    @Override
    public int compareTo(@NotNull ImmutablePairByte o) {
        return Comparator.comparing(ImmutablePairByte::getFirst)
                .thenComparing(ImmutablePairByte::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutablePairByte pair = (ImmutablePairByte) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "ImmutablePairByte{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static ImmutablePairByte valueOf(byte first, byte second) {
        return new ImmutablePairByte(first, second);
    }
}
