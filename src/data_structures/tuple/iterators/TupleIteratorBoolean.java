package data_structures.tuple.iterators;

import data_structures.tuple.TupleBoolean;
import data_structures.tuple.TupleByte;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorBoolean implements Iterator<Boolean> {
    private final TupleBoolean tuple;
    private int p;

    public TupleIteratorBoolean(TupleBoolean tuple) {
        this.tuple = tuple;
        this.p = 0;
    }

    @Override
    public boolean hasNext() {
        return p < tuple.length;
    }

    @Override
    public Boolean next() {
        if (this.hasNext()){
            return tuple.get(p++);
        }

        throw new NoSuchElementException("tuple");
    }
}
