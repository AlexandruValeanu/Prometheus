package data_structures.pair.mutable;

import data_structures.pair.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

/**
 * MutablePair (tuple of two)
 */
public class MutablePair<T, S> implements Pair<T, S> {

    public T first;
    public S second;

    public MutablePair(){
        this.first = null;
        this.second = null;
    }

    public MutablePair(T first, S second) {
        this.first = first;
        this.second = second;
    }

    public MutablePair(@NotNull Map.Entry<T, S> entry){
        this.first = entry.getKey();
        this.second = entry.getValue();
    }

    public MutablePair(@NotNull org.apache.commons.lang3.tuple.Pair<T, S> pair){
        this.first = pair.getLeft();
        this.second = pair.getRight();
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
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
        setSecond(value);
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutablePair<?, ?> pair = (MutablePair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "MutablePair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
