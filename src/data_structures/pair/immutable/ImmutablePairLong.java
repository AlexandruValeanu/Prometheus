package data_structures.pair.immutable;

import data_structures.pair.mutable.PairLong;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

final public class ImmutablePairLong implements Comparable<ImmutablePairLong> {
    public final long first;
    public final long second;

    public ImmutablePairLong() {
        this.first = 0;
        this.second = 0;
    }

    public ImmutablePairLong(long first, long second) {
        this.first = first;
        this.second = second;
    }

    public ImmutablePairLong(PairLong pairLong) {
        this.first = pairLong.first;
        this.second = pairLong.second;
    }

    public ImmutablePairLong(ImmutablePairLong pairLong) {
        this.first = pairLong.first;
        this.second = pairLong.second;
    }

    public long getFirst() {
        return first;
    }

    public long getSecond() {
        return second;
    }

    @Override
    public int compareTo(@NotNull ImmutablePairLong o) {
        return Comparator.comparing(ImmutablePairLong::getFirst)
                .thenComparing(ImmutablePairLong::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutablePairLong pair = (ImmutablePairLong) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "ImmutablePairLong{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static ImmutablePairLong valueOf(long first, long second) {
        return new ImmutablePairLong(first, second);
    }
}
