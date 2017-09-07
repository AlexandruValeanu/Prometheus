package data_structures.triple.mutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class TripleInt implements Comparable<TripleInt> {
    public int first;
    public int second;
    public int third;

    public TripleInt() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public TripleInt(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }

    @Override
    public int compareTo(@NotNull TripleInt o) {
        return Comparator.comparing(TripleInt::getFirst)
                .thenComparing(TripleInt::getSecond)
                .thenComparing(TripleInt::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripleInt that = (TripleInt) o;
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
        return "TripleInt{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
