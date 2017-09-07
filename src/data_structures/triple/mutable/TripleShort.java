package data_structures.triple.mutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class TripleShort implements Comparable<TripleShort> {
    public short first;
    public short second;
    public short third;

    public TripleShort() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public TripleShort(short first, short second, short third) {
        this.first = first;
        this.second = second;
        this.third = third;
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

    public short getThird() {
        return third;
    }

    public void setThird(short third) {
        this.third = third;
    }

    @Override
    public int compareTo(@NotNull TripleShort o) {
        return Comparator.comparing(TripleShort::getFirst)
                .thenComparing(TripleShort::getSecond)
                .thenComparing(TripleShort::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripleShort that = (TripleShort) o;
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
        return "ImmutableTripleShort{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
