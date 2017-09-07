package data_structures.pair;

import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

/**
 * MutableTriple (tuple of two)
 */
public class MutablePair<T, S> implements Pair<T, S> {

    T first;
    S second;

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

    public MutablePair(@NotNull MutablePair<T, S> entry){
        this.first = entry.getFirst();
        this.second = entry.getSecond();
    }

    public MutablePair(@NotNull ImmutablePair<T, S> entry){
        this.first = entry.getFirst();
        this.second = entry.getSecond();
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
