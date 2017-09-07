package data_structures.triple.mutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class TripleBoolean implements Comparable<TripleBoolean> {
    public boolean first;
    public boolean second;
    public boolean third;

    public TripleBoolean() {
        this.first = false;
        this.second = false;
        this.third = false;
    }

    public TripleBoolean(boolean first, boolean second, boolean third) {
        this.first = first;
        this.second = second;
        this.third = third;
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

    public boolean getThird() {
        return third;
    }

    public void setThird(boolean third) {
        this.third = third;
    }

    @Override
    public int compareTo(@NotNull TripleBoolean o) {
        return Comparator.comparing(TripleBoolean::getFirst)
                .thenComparing(TripleBoolean::getSecond)
                .thenComparing(TripleBoolean::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripleBoolean that = (TripleBoolean) o;
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
        return "ImmutableTripleBoolean{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
