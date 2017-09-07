package data_structures.pair.immutable;

import data_structures.pair.mutable.PairInt;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

final public class ImmutablePairInt implements Comparable<ImmutablePairInt> {
    public final int first;
    public final int second;

    public ImmutablePairInt() {
        this.first = 0;
        this.second = 0;
    }

    public ImmutablePairInt(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public ImmutablePairInt(PairInt pairInt) {
        this.first = pairInt.first;
        this.second = pairInt.second;
    }

    public ImmutablePairInt(ImmutablePairInt pairInt) {
        this.first = pairInt.first;
        this.second = pairInt.second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public int compareTo(@NotNull ImmutablePairInt o) {
        return Comparator.comparing(ImmutablePairInt::getFirst)
                .thenComparing(ImmutablePairInt::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutablePairInt pair = (ImmutablePairInt) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "ImmutablePairInt{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static ImmutablePairInt valueOf(int first, int second) {
        return new ImmutablePairInt(first, second);
    }
}
