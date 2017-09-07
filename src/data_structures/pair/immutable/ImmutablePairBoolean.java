package data_structures.pair.immutable;

import data_structures.pair.mutable.PairBoolean;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

final public class ImmutablePairBoolean implements Comparable<ImmutablePairBoolean> {
    public final boolean first;
    public final boolean second;

    public ImmutablePairBoolean() {
        this.first = false;
        this.second = false;
    }

    public ImmutablePairBoolean(boolean first, boolean second) {
        this.first = first;
        this.second = second;
    }

    public ImmutablePairBoolean(PairBoolean pairBoolean) {
        this.first = pairBoolean.first;
        this.second = pairBoolean.second;
    }

    public ImmutablePairBoolean(ImmutablePairBoolean pairBoolean) {
        this.first = pairBoolean.first;
        this.second = pairBoolean.second;
    }

    public boolean getFirst() {
        return first;
    }

    public boolean getSecond() {
        return second;
    }

    @Override
    public int compareTo(@NotNull ImmutablePairBoolean o) {
        return Comparator.comparing(ImmutablePairBoolean::getFirst)
                .thenComparing(ImmutablePairBoolean::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutablePairBoolean pair = (ImmutablePairBoolean) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "ImmutablePairBoolean{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static ImmutablePairBoolean valueOf(boolean first, boolean second) {
        return new ImmutablePairBoolean(first, second);
    }
}
