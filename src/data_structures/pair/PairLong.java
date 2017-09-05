package data_structures.pair;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PairLong implements Comparable<PairLong> {
    long first;
    long second;

    public PairLong() {
        this.first = 0;
        this.second = 0;
    }

    public PairLong(long first, long second) {
        this.first = first;
        this.second = second;
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
        int c = Long.compare(first, o.first);

        if (c != 0)
            return c;
        else
            return Long.compare(second, o.second);
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
        return first + " " + second;
    }
}
