package data_structures.triple.immutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class ImmutableTripleLong implements Comparable<ImmutableTripleLong> {
    public final long first;
    public final long second;
    public final long third;

    public ImmutableTripleLong() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public ImmutableTripleLong(long first, long second, long third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public long getFirst() {
        return first;
    }

    public long getSecond() {
        return second;
    }

    public long getThird() {
        return third;
    }

    @Override
    public int compareTo(@NotNull ImmutableTripleLong o) {
        return Comparator.comparing(ImmutableTripleLong::getFirst)
                .thenComparing(ImmutableTripleLong::getSecond)
                .thenComparing(ImmutableTripleLong::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTripleLong that = (ImmutableTripleLong) o;
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
