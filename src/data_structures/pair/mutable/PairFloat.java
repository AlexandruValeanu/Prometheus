package data_structures.pair.mutable;

import data_structures.pair.immutable.ImmutablePairFloat;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class PairFloat implements Comparable<PairFloat> {
    public float first;
    public float second;

    public PairFloat() {
        this.first = 0;
        this.second = 0;
    }

    public PairFloat(float first, float second) {
        this.first = first;
        this.second = second;
    }

    public PairFloat(PairFloat pairFloat) {
        this.first = pairFloat.first;
        this.second = pairFloat.second;
    }

    public PairFloat(ImmutablePairFloat pairFloat) {
        this.first = pairFloat.first;
        this.second = pairFloat.second;
    }

    public float getFirst() {
        return first;
    }

    public void setFirst(float first) {
        this.first = first;
    }

    public float getSecond() {
        return second;
    }

    public void setSecond(float second) {
        this.second = second;
    }

    @Override
    public int compareTo(@NotNull PairFloat o) {
        return Comparator.comparing(PairFloat::getFirst)
                .thenComparing(PairFloat::getSecond)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairFloat pair = (PairFloat) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "PairFloat{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // static methods

    @NotNull
    static PairFloat valueOf(float first, float second) {
        return new PairFloat(first, second);
    }
}
