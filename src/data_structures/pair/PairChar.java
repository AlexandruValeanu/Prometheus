package data_structures.pair;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PairChar implements Comparable<PairChar> {
    char first;
    char second;

    public PairChar() {
        this.first = 0;
        this.second = 0;
    }

    public PairChar(char first, char second) {
        this.first = first;
        this.second = second;
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
        int c = Character.compare(first, o.first);

        if (c != 0)
            return c;
        else
            return Character.compare(second, o.second);
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
        return first + " " + second;
    }
}
