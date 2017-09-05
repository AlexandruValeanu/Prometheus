package data_structures.tuple.iterators;

import data_structures.tuple.TupleFloat;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorFloat implements Iterator<Float> {
    private final TupleFloat tuple;
    private int p;

    public TupleIteratorFloat(TupleFloat tuple) {
        this.tuple = tuple;
        this.p = 0;
    }

    @Override
    public boolean hasNext() {
        return p < tuple.length;
    }

    @Override
    public Float next() {
        if (this.hasNext()){
            return tuple.get(p++);
        }

        throw new NoSuchElementException("tuple");
    }
}
