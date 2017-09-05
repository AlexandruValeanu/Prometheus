package data_structures.tuple;

import data_structures.tuple.iterators.TupleIterator;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Tuple<E> implements Iterable<E> {
    private E[] elems;
    public final int length;

    @SafeVarargs
    public Tuple(E... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, E element){
        elems[index] = element;
    }

    public E get(int index){
        return elems[index];
    }

    @NotNull
    @SafeVarargs
    public final Tuple<E> add(E... elements){
        return new Tuple<>(ArrayUtils.addAll(elems, elements));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?> tuple = (Tuple<?>) o;
        return Arrays.equals(elems, tuple.elems);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elems);
    }

    @Override
    public String toString() {
        return Arrays.toString(elems);
    }

    public E[] toArray(){
        return elems.clone();
    }

    public List<E> toList(){
        return Arrays.asList(elems);
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new TupleIterator<>(this);
    }
}
