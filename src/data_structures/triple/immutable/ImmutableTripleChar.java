package data_structures.triple.immutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class ImmutableTripleChar implements Comparable<ImmutableTripleChar> {
    public final char first;
    public final char second;
    public final char third;

    public ImmutableTripleChar() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public ImmutableTripleChar(char first, char second, char third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public char getFirst() {
        return first;
    }

    public char getSecond() {
        return second;
    }

    public char getThird() {
        return third;
    }

    @Override
    public int compareTo(@NotNull ImmutableTripleChar o) {
        return Comparator.comparing(ImmutableTripleChar::getFirst)
                .thenComparing(ImmutableTripleChar::getSecond)
                .thenComparing(ImmutableTripleChar::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTripleChar that = (ImmutableTripleChar) o;
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
        return "ImmutableTripleChar{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
