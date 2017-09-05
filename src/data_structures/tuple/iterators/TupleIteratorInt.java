package data_structures.tuple.iterators;

import data_structures.tuple.TupleInt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorInt implements Iterator<Integer> {
    private final TupleInt tuple;
    private int p;

    public TupleIteratorInt(TupleInt tuple) {
        this.tuple = tuple;
        this.p = 0;
    }

    @Override
    public boolean hasNext() {
        return p < tuple.length;
    }

    @Override
    public Integer next() {
        if (this.hasNext()){
            return tuple.get(p++);
        }

        throw new NoSuchElementException("tuple");
    }
}
