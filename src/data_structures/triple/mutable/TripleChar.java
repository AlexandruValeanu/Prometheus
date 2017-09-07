package data_structures.triple.mutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class TripleChar implements Comparable<TripleChar> {
    public char first;
    public char second;
    public char third;

    public TripleChar() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public TripleChar(char first, char second, char third) {
        this.first = first;
        this.second = second;
        this.third = third;
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

    public char getThird() {
        return third;
    }

    public void setThird(char third) {
        this.third = third;
    }

    @Override
    public int compareTo(@NotNull TripleChar o) {
        return Comparator.comparing(TripleChar::getFirst)
                .thenComparing(TripleChar::getSecond)
                .thenComparing(TripleChar::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripleChar that = (TripleChar) o;
        return first == that.first &&
                second == that.second &&
                third == that.third;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return "TripleChar{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
