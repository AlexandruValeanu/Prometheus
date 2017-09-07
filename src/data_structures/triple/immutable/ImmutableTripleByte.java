package data_structures.triple.immutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class ImmutableTripleByte implements Comparable<ImmutableTripleByte> {
    public final byte first;
    public final byte second;
    public final byte third;

    public ImmutableTripleByte() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public ImmutableTripleByte(byte first, byte second, byte third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public byte getFirst() {
        return first;
    }

    public byte getSecond() {
        return second;
    }

    public byte getThird() {
        return third;
    }

    @Override
    public int compareTo(@NotNull ImmutableTripleByte o) {
        return Comparator.comparing(ImmutableTripleByte::getFirst)
                .thenComparing(ImmutableTripleByte::getSecond)
                .thenComparing(ImmutableTripleByte::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTripleByte that = (ImmutableTripleByte) o;
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
