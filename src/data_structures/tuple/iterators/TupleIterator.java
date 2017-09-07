package data_structures.tuple.iterators;

import data_structures.tuple.Tuple;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIterator<E> implements Iterator<E> {
    private final Tuple<E> tuple;
    private int p;

    public TupleIterator(Tuple<E> tuple) {
        this.tuple = tuple;
        this.p = 0;
    }

    @Override
    public boolean hasNext() {
        return p < tuple.size();
    }

    @Override
    public E next() {
        if (this.hasNext()){
            return tuple.get(p++);
        }

        throw new NoSuchElementException("tuple");
    }
}
