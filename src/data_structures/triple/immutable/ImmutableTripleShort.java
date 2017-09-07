package data_structures.triple.immutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class ImmutableTripleShort implements Comparable<ImmutableTripleShort> {
    public final short first;
    public final short second;
    public final short third;

    public ImmutableTripleShort() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public ImmutableTripleShort(short first, short second, short third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public short getFirst() {
        return first;
    }

    public short getSecond() {
        return second;
    }

    public short getThird() {
        return third;
    }

    @Override
    public int compareTo(@NotNull ImmutableTripleShort o) {
        return Comparator.comparing(ImmutableTripleShort::getFirst)
                .thenComparing(ImmutableTripleShort::getSecond)
                .thenComparing(ImmutableTripleShort::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTripleShort that = (ImmutableTripleShort) o;
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
