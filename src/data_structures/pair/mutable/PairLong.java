package data_structures.pair.mutable;

import data_structures.pair.immutable.ImmutablePairLong;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class PairLong implements Comparable<PairLong> {
    public long first;
    public long second;

    public PairLong() {
        this.first = 0;
        this.second = 0;
    }

    public PairLong(long first, long second) {
        this.first = first;
        this.second = second;
    }

    public PairLong(PairLong pairLong) {
        this.first = pairLong.first;
        this.second = pairLong.second;
    }

    public PairLong(ImmutablePairLong pairLong) {
        this.first = pairLong.first;
        this.second = pairLong.second;
    }

    public long getFirst() {
        return first;
    }

    public void setFirst(long first) {
        this.first = first;
    }

    public long getSecond() {
        return second;
    }

    public void setSecond(long second) {
        this.second = second;
    }

    @Override
    public int compareTo(@NotNull PairLong o) {
        return Comparator.comparing(PairLong::getFirst)
                .thenComparing(PairLong::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairLong pair = (PairLong) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "PairLong{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static PairLong valueOf(long first, long second) {
        return new PairLong(first, second);
    }
}
