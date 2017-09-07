package data_structures.triple.immutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class ImmutableTripleInt implements Comparable<ImmutableTripleInt> {
    public final int first;
    public final int second;
    public final int third;

    public ImmutableTripleInt() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public ImmutableTripleInt(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    @Override
    public int compareTo(@NotNull ImmutableTripleInt o) {
        return Comparator.comparing(ImmutableTripleInt::getFirst)
                .thenComparing(ImmutableTripleInt::getSecond)
                .thenComparing(ImmutableTripleInt::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTripleInt that = (ImmutableTripleInt) o;
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
        return "ImmutableTripleInt{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
