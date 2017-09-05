package data_structures.tuple.iterators;

import data_structures.tuple.TupleLong;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorLong implements Iterator<Long> {
    private final TupleLong tuple;
    private int p;

    public TupleIteratorLong(TupleLong tuple) {
        this.tuple = tuple;
        this.p = 0;
    }

    @Override
    public boolean hasNext() {
        return p < tuple.length;
    }

    @Override
    public Long next() {
        if (this.hasNext()){
            return tuple.get(p++);
        }

        throw new NoSuchElementException("tuple");
    }
}
