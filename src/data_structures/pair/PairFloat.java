package data_structures.pair;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PairFloat implements Comparable<PairFloat> {
    float first;
    float second;

    public PairFloat() {
        this.first = 0;
        this.second = 0;
    }

    public PairFloat(float first, float second) {
        this.first = first;
        this.second = second;
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
        int c = Float.compare(first, o.first);

        if (c != 0)
            return c;
        else
            return Float.compare(second, o.second);
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
        return first + " " + second;
    }
}
