package data_structures.tuple.iterators;

import data_structures.tuple.TupleInt;
import data_structures.tuple.TupleShort;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorShort implements Iterator<Short> {
    private final TupleShort tuple;
    private int p;

    public TupleIteratorShort(TupleShort tuple) {
        this.tuple = tuple;
        this.p = 0;
    }

    @Override
    public boolean hasNext() {
        return p < tuple.length;
    }

    @Override
    public Short next() {
        if (this.hasNext()){
            return tuple.get(p++);
        }

        throw new NoSuchElementException("tuple");
    }
}
