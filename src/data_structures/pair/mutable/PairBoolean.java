package data_structures.pair.mutable;

import data_structures.pair.Pair;
import data_structures.pair.immutable.ImmutablePairBoolean;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class PairBoolean implements Comparable<PairBoolean> {
    public boolean first;
    public boolean second;

    public PairBoolean() {
        this.first = false;
        this.second = false;
    }

    public PairBoolean(boolean first, boolean second) {
        this.first = first;
        this.second = second;
    }

    public PairBoolean(PairBoolean pairBoolean) {
        this.first = pairBoolean.first;
        this.second = pairBoolean.second;
    }

    public PairBoolean(ImmutablePairBoolean pairBoolean) {
        this.first = pairBoolean.first;
        this.second = pairBoolean.second;
    }

    public boolean getFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean getSecond() {
        return second;
    }

    public void setSecond(boolean second) {
        this.second = second;
    }

    @Override
    public int compareTo(@NotNull PairBoolean o) {
        return Comparator.comparing(PairBoolean::getFirst)
                .thenComparing(PairBoolean::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairBoolean pair = (PairBoolean) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "PairBoolean{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static PairBoolean valueOf(boolean first, boolean second) {
        return new PairBoolean(first, second);
    }
}
