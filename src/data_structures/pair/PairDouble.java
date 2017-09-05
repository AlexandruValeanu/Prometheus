package data_structures.pair;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PairDouble implements Comparable<PairDouble> {
    double first;
    double second;

    public PairDouble() {
        this.first = 0;
        this.second = 0;
    }

    public PairDouble(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    @Override
    public int compareTo(@NotNull PairDouble o) {
        int c = Double.compare(first, o.first);

        if (c != 0)
            return c;
        else
            return Double.compare(second, o.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairDouble pair = (PairDouble) o;
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
