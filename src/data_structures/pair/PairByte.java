package data_structures.pair;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PairByte implements Comparable<PairByte> {
    byte first;
    byte second;

    public PairByte() {
        this.first = 0;
        this.second = 0;
    }

    public PairByte(byte first, byte second) {
        this.first = first;
        this.second = second;
    }

    public byte getFirst() {
        return first;
    }

    public void setFirst(byte first) {
        this.first = first;
    }

    public byte getSecond() {
        return second;
    }

    public void setSecond(byte second) {
        this.second = second;
    }

    @Override
    public int compareTo(@NotNull PairByte o) {
        int c = Byte.compare(first, o.first);

        if (c != 0)
            return c;
        else
            return Byte.compare(second, o.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairByte pair = (PairByte) o;
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
