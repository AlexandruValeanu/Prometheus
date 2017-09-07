package data_structures.triple.mutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class TripleByte implements Comparable<TripleByte> {
    public byte first;
    public byte second;
    public byte third;

    public TripleByte() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public TripleByte(byte first, byte second, byte third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public byte getFirst() {
        return first;
    }

    public void setFirst(byte first) {
        this.first = first;
    }

    public byte getSecond() {
        return second;
    }

    public void setSecond(byte second) {
        this.second = second;
    }

    public byte getThird() {
        return third;
    }

    public void setThird(byte third) {
        this.third = third;
    }

    @Override
    public int compareTo(@NotNull TripleByte o) {
        return Comparator.comparing(TripleByte::getFirst)
                .thenComparing(TripleByte::getSecond)
                .thenComparing(TripleByte::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripleByte that = (TripleByte) o;
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
        return "ImmutableTripleByte{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
