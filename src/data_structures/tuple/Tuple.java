package data_structures.tuple;

import data_structures.tuple.immutable.ImmutableTuple;
import data_structures.tuple.iterators.TupleIterator;
import data_structures.tuple.mutable.MutableTuple;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

public interface Tuple<E> extends Iterable<E> {

    void set(int index, E element);

    E get(int index);

    int size();

    E[] toArray();
    List<E> toList();

    @NotNull
    @SafeVarargs
    static <T> Tuple<T> valueOf(T... elements){
        return new MutableTuple<>(elements);
    }

    @NotNull
    @SafeVarargs
    static <T> Tuple<T> valueOfImmutable(T... elements){
        return new ImmutableTuple<>(elements);
    }

    @NotNull
    @SafeVarargs
    static <T> Tuple<T> valueOf(@NotNull Tuple<T> tuple, T... elements){
        return new MutableTuple<>(ArrayUtils.addAll(tuple.toArray(), elements));
    }

    @NotNull
    @SafeVarargs
    static <T> Tuple<T> valueOfImmutable(@NotNull Tuple<T> tuple, T... elements){
        return new ImmutableTuple<>(ArrayUtils.addAll(tuple.toArray(), elements));
    }

    @NotNull
    default Iterator<E> iterator() {
        return new TupleIterator<>(this);
    }

}
