package data_structures.triple.mutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class TripleFloat implements Comparable<TripleFloat> {
    public float first;
    public float second;
    public float third;

    public TripleFloat() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public TripleFloat(float first, float second, float third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public float getFirst() {
        return first;
    }

    public void setFirst(float first) {
        this.first = first;
    }

    public float getSecond() {
        return second;
    }

    public void setSecond(float second) {
        this.second = second;
    }

    public float getThird() {
        return third;
    }

    public void setThird(float third) {
        this.third = third;
    }

    @Override
    public int compareTo(@NotNull TripleFloat o) {
        return Comparator.comparing(TripleFloat::getFirst)
                .thenComparing(TripleFloat::getSecond)
                .thenComparing(TripleFloat::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripleFloat that = (TripleFloat) o;
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
        return "TripleFloat{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
