package data_structures.tuple.iterators;

import data_structures.tuple.immutable.ImmutableTupleDouble;
import data_structures.tuple.mutable.TupleDouble;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorDouble implements Iterator<Double> {
    private final TupleDouble tuple;
    private final ImmutableTupleDouble imtuple;
    private int p;

    public TupleIteratorDouble(TupleDouble tuple) {
        this.tuple = tuple;
        this.imtuple = null;
        this.p = 0;
    }

    public TupleIteratorDouble(ImmutableTupleDouble tuple) {
        this.tuple = null;
        this.imtuple = tuple;
        this.p = 0;
    }

    @Override
    public boolean hasNext() {
        if (tuple != null)
            return p < tuple.length;
        else {
            assert imtuple != null;
            return p < imtuple.length;
        }
    }

    @Override
    public Double next() {
        if (this.hasNext()){

            if (tuple != null)
                return tuple.get(p++);
            else {
                assert imtuple != null;
                return imtuple.get(p++);
            }
        }

        throw new NoSuchElementException("tuple");
    }
}
