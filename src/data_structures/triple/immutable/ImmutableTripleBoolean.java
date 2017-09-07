package data_structures.triple.immutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class ImmutableTripleBoolean implements Comparable<ImmutableTripleBoolean> {
    public final boolean first;
    public final boolean second;
    public final boolean third;

    public ImmutableTripleBoolean() {
        this.first = false;
        this.second = false;
        this.third = false;
    }

    public ImmutableTripleBoolean(boolean first, boolean second, boolean third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public boolean getFirst() {
        return first;
    }

    public boolean getSecond() {
        return second;
    }

    public boolean getThird() {
        return third;
    }

    @Override
    public int compareTo(@NotNull ImmutableTripleBoolean o) {
        return Comparator.comparing(ImmutableTripleBoolean::getFirst)
                .thenComparing(ImmutableTripleBoolean::getSecond)
                .thenComparing(ImmutableTripleBoolean::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTripleBoolean that = (ImmutableTripleBoolean) o;
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
