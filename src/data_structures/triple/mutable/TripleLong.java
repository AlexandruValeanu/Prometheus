package data_structures.triple.mutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class TripleLong implements Comparable<TripleLong> {
    public long first;
    public long second;
    public long third;

    public TripleLong() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public TripleLong(long first, long second, long third) {
        this.first = first;
        this.second = second;
        this.third = third;
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

    public long getThird() {
        return third;
    }

    public void setThird(long third) {
        this.third = third;
    }

    @Override
    public int compareTo(@NotNull TripleLong o) {
        return Comparator.comparing(TripleLong::getFirst)
                .thenComparing(TripleLong::getSecond)
                .thenComparing(TripleLong::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripleLong that = (TripleLong) o;
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
        return "TripleShort{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
