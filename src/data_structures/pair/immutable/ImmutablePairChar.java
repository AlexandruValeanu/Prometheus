package data_structures.pair.immutable;

import data_structures.pair.mutable.PairChar;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

final public class ImmutablePairChar implements Comparable<ImmutablePairChar> {
    public final char first;
    public final char second;

    public ImmutablePairChar() {
        this.first = 0;
        this.second = 0;
    }

    public ImmutablePairChar(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public ImmutablePairChar(PairChar pairChar) {
        this.first = pairChar.first;
        this.second = pairChar.second;
    }

    public ImmutablePairChar(ImmutablePairChar pairChar) {
        this.first = pairChar.first;
        this.second = pairChar.second;
    }

    public char getFirst() {
        return first;
    }

    public char getSecond() {
        return second;
    }

    @Override
    public int compareTo(@NotNull ImmutablePairChar o) {
        return Comparator.comparing(ImmutablePairChar::getFirst)
                .thenComparing(ImmutablePairChar::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutablePairChar pair = (ImmutablePairChar) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "ImmutablePairChar{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static ImmutablePairChar valueOf(char first, char second) {
        return new ImmutablePairChar(first, second);
    }
}
