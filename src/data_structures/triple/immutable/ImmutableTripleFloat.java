package data_structures.triple.immutable;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class ImmutableTripleFloat implements Comparable<ImmutableTripleFloat> {
    public final float first;
    public final float second;
    public final float third;

    public ImmutableTripleFloat() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    public ImmutableTripleFloat(float first, float second, float third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public float getFirst() {
        return first;
    }

    public float getSecond() {
        return second;
    }

    public float getThird() {
        return third;
    }

    @Override
    public int compareTo(@NotNull ImmutableTripleFloat o) {
        return Comparator.comparing(ImmutableTripleFloat::getFirst)
                .thenComparing(ImmutableTripleFloat::getSecond)
                .thenComparing(ImmutableTripleFloat::getThird)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTripleFloat that = (ImmutableTripleFloat) o;
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
        return "ImmutableTripleFloat{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
