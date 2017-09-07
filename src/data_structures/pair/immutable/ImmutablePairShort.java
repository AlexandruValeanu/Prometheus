package data_structures.pair.immutable;

import data_structures.pair.mutable.PairShort;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

final public class ImmutablePairShort implements Comparable<ImmutablePairShort> {
    public final short first;
    public final short second;

    public ImmutablePairShort() {
        this.first = 0;
        this.second = 0;
    }

    public ImmutablePairShort(short first, short second) {
        this.first = first;
        this.second = second;
    }

    public ImmutablePairShort(PairShort pairShort) {
        this.first = pairShort.first;
        this.second = pairShort.second;
    }

    public ImmutablePairShort(ImmutablePairShort pairShort) {
        this.first = pairShort.first;
        this.second = pairShort.second;
    }

    public short getFirst() {
        return first;
    }
    public short getSecond() {
        return second;
    }

    @Override
    public int compareTo(@NotNull ImmutablePairShort o) {
        return Comparator.comparing(ImmutablePairShort::getFirst)
                .thenComparing(ImmutablePairShort::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutablePairShort pair = (ImmutablePairShort) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "ImmutablePairShort{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static ImmutablePairShort valueOf(short first, short second) {
        return new ImmutablePairShort(first, second);
    }
}
