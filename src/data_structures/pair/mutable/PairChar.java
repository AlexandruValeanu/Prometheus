package data_structures.pair.mutable;

import data_structures.pair.immutable.ImmutablePairChar;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class PairChar implements Comparable<PairChar> {
    public char first;
    public char second;

    public PairChar() {
        this.first = 0;
        this.second = 0;
    }

    public PairChar(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public PairChar(PairChar pairChar) {
        this.first = pairChar.first;
        this.second = pairChar.second;
    }

    public PairChar(ImmutablePairChar pairChar) {
        this.first = pairChar.first;
        this.second = pairChar.second;
    }

    public char getFirst() {
        return first;
    }

    public void setFirst(char first) {
        this.first = first;
    }

    public char getSecond() {
        return second;
    }

    public void setSecond(char second) {
        this.second = second;
    }

    @Override
    public int compareTo(@NotNull PairChar o) {
        return Comparator.comparing(PairChar::getFirst)
                .thenComparing(PairChar::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairChar pair = (PairChar) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "PairChar{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static PairChar valueOf(char first, char second) {
        return new PairChar(first, second);
    }
}
