package data_structures.pair;

import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

/**
 * MutableTriple (tuple of two)
 */
public class ImmutablePair<T, S> implements Pair<T, S> {
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

    public ImmutablePair(@NotNull ImmutablePair<T, S> entry){
        this.first = entry.first;
        this.second = entry.second;
    }

    public ImmutablePair(@NotNull MutablePair<T, S> entry){
        this.first = entry.first;
        this.second = entry.second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        throw new UnsupportedOperationException("immutable pair");
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        throw new UnsupportedOperationException("immutable pair");
    }

    @Override
    public Map.Entry<T, S> toMapEntry(){
        return new AbstractMap.SimpleEntry<>(first, second);
    }

    @Override
    public Map.Entry<T, S> toMapEntryImmutable() {
        return new AbstractMap.SimpleImmutableEntry<>(first, second);
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
