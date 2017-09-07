package data_structures.triple.mutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class TripleDouble implements Comparable<TripleDouble> {
    public double first;
    public double second;
    public double third;

    public TripleDouble() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public TripleDouble(double first, double second, double third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public double getThird() {
        return third;
    }

    public void setThird(double third) {
        this.third = third;
    }

    @Override
    public int compareTo(@NotNull TripleDouble o) {
        return Comparator.comparing(TripleDouble::getFirst)
                .thenComparing(TripleDouble::getSecond)
                .thenComparing(TripleDouble::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripleDouble that = (TripleDouble) o;
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
