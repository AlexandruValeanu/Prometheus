package data_structures.pair;

import java.util.Objects;

public class PairChar {
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
