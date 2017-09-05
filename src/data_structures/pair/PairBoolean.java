package data_structures.pair;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PairBoolean implements Comparable<PairBoolean> {
    boolean first;
    boolean second;

    public PairBoolean() {
        this.first = false;
        this.second = false;
    }

    public PairBoolean(boolean first, boolean second) {
        this.first = first;
        this.second = second;
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
        int c = Boolean.compare(first, o.first);

        if (c != 0)
            return c;
        else
            return Boolean.compare(second, o.second);
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
        return first + " " + second;
    }
}
