package data_structures.triple.mutable;

import data_structures.triple.Triple;
import data_structures.triple.immutable.ImmutableTriple;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * MutableTriple (tuple of three)
 */
public class MutableTriple<T, S, U> implements Triple<T, S, U> {
    public T first;
    public S second;
    public U third;

    public MutableTriple(){
        this.first = null;
        this.second = null;
        this.third = null;
    }

    public MutableTriple(T first, S second, U third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public MutableTriple(@NotNull Triple<T, S, U> entry){
        this.first = entry.getFirst();
        this.second = entry.getSecond();
        this.third = entry.getThird();
    }

    @Override
    public T getFirst() {
        return first;
    }

    @Override
    public void setFirst(T first) {
        this.first = first;
    }

    @Override
    public S getSecond() {
        return second;
    }

    @Override
    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public U getThird() {
        return third;
    }

    @Override
    public void setThird(U third) {
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableTriple<?, ?, ?> that = (MutableTriple<?, ?, ?>) o;
        return Objects.equals(first, that.first) &&
                Objects.equals(second, that.second) &&
                Objects.equals(third, that.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return "MutableTriple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
