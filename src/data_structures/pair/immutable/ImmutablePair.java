package data_structures.pair.immutable;

import data_structures.pair.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

/**
 * ImmutablePair (tuple of two)
 */
final public class ImmutablePair<T, S> implements Pair<T, S> {

    public final T first;
    public final S second;

    public ImmutablePair(){
        this.first = null;
        this.second = null;
    }

    public ImmutablePair(T first, S second) {
        this.first = first;
        this.second = second;
    }

    public ImmutablePair(@NotNull Map.Entry<T, S> entry){
        this.first = entry.getKey();
        this.second = entry.getValue();
    }

    public ImmutablePair(@NotNull org.apache.commons.lang3.tuple.Pair<T, S> pair){
        this.first = pair.getLeft();
        this.second = pair.getRight();
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        throw new UnsupportedOperationException();
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T getKey() {
        return first;
    }

    @Override
    public S getValue() {
        return second;
    }

    @Override
    public S setValue(S value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutablePair<?, ?> pair = (ImmutablePair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "ImmutablePair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
