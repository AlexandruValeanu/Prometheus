package data_structures.tuple.iterators;

import data_structures.tuple.immutable.ImmutableTupleShort;
import data_structures.tuple.mutable.TupleShort;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorShort implements Iterator<Short> {
    private final TupleShort tuple;
    private final ImmutableTupleShort imtuple;
    private int p;

    public TupleIteratorShort(TupleShort tuple) {
        this.tuple = tuple;
        this.imtuple = null;
        this.p = 0;
    }

    public TupleIteratorShort(ImmutableTupleShort tuple) {
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
    public Short next() {
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
