package data_structures.tuple.iterators;

import data_structures.tuple.TupleDouble;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorDouble implements Iterator<Double> {
    private final TupleDouble tuple;
    private int p;

    public TupleIteratorDouble(TupleDouble tuple) {
        this.tuple = tuple;
        this.p = 0;
    }

    @Override
    public boolean hasNext() {
        return p < tuple.length;
    }

    @Override
    public Double next() {
        if (this.hasNext()){
            return tuple.get(p++);
        }

        throw new NoSuchElementException("tuple");
    }
}
