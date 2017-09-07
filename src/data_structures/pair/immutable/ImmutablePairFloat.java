package data_structures.pair.immutable;

import data_structures.pair.mutable.PairFloat;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

final public class ImmutablePairFloat implements Comparable<ImmutablePairFloat> {
    public final float first;
    public final float second;

    public ImmutablePairFloat() {
        this.first = 0;
        this.second = 0;
    }

    public ImmutablePairFloat(float first, float second) {
        this.first = first;
        this.second = second;
    }

    public ImmutablePairFloat(PairFloat pairFloat) {
        this.first = pairFloat.first;
        this.second = pairFloat.second;
    }

    public ImmutablePairFloat(ImmutablePairFloat pairFloat) {
        this.first = pairFloat.first;
        this.second = pairFloat.second;
    }

    public float getFirst() {
        return first;
    }

    public float getSecond() {
        return second;
    }

    @Override
    public int compareTo(@NotNull ImmutablePairFloat o) {
        return Comparator.comparing(ImmutablePairFloat::getFirst)
                .thenComparing(ImmutablePairFloat::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutablePairFloat pair = (ImmutablePairFloat) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "ImmutablePairFloat{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static ImmutablePairFloat valueOf(float first, float second) {
        return new ImmutablePairFloat(first, second);
    }
}
