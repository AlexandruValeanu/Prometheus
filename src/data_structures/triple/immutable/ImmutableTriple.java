package data_structures.triple.immutable;

import data_structures.triple.mutable.MutableTriple;
import data_structures.triple.Triple;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * MutableTriple (tuple of three)
 */
public class ImmutableTriple<T, S, U> implements Triple<T, S, U> {
    public final T first;
    public final S second;
    public final U third;

    public ImmutableTriple(){
        this.first = null;
        this.second = null;
        this.third = null;
    }

    public ImmutableTriple(T first, S second, U third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public ImmutableTriple(@NotNull Triple<T, S, U> entry){
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
        throw new UnsupportedOperationException("immutable triple");
    }

    @Override
    public S getSecond() {
        return second;
    }

    @Override
    public void setSecond(S second) {
        throw new UnsupportedOperationException("immutable triple");
    }

    @Override
    public U getThird() {
        return third;
    }

    @Override
    public void setThird(U third) {
        throw new UnsupportedOperationException("immutable triple");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTriple<?, ?, ?> that = (ImmutableTriple<?, ?, ?>) o;
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
        return "ImmutableTriple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
