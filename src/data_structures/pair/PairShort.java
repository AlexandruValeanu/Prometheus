package data_structures.pair;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PairShort implements Comparable<PairShort> {
    short first;
    short second;

    public PairShort() {
        this.first = 0;
        this.second = 0;
    }

    public PairShort(short first, short second) {
        this.first = first;
        this.second = second;
    }

    public short getFirst() {
        return first;
    }

    public void setFirst(short first) {
        this.first = first;
    }

    public short getSecond() {
        return second;
    }

    public void setSecond(short second) {
        this.second = second;
    }

    @Override
    public int compareTo(@NotNull PairShort o) {
        int c = Short.compare(first, o.first);

        if (c != 0)
            return c;
        else
            return Short.compare(second, o.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairShort pair = (PairShort) o;
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
