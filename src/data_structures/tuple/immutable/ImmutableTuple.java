package data_structures.tuple.immutable;

import data_structures.tuple.Tuple;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class ImmutableTuple<E> implements Tuple<E> {
    private E[] elems;
    public final int length;

    @SafeVarargs
    public ImmutableTuple(E... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, E element){
        elems[index] = element;
    }

    public E get(int index){
        throw new UnsupportedOperationException("immutable tuple");
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTuple<?> mutableTuple = (ImmutableTuple<?>) o;
        return Arrays.equals(elems, mutableTuple.elems);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elems);
    }

    @Override
    public String toString() {
        return Arrays.toString(elems);
    }

    @Override
    public E[] toArray(){
        return elems.clone();
    }

    @Override
    public List<E> toList(){
        return Arrays.asList(elems);
    }
}
