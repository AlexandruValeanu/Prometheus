package data_structures.tuple.iterators;

import data_structures.tuple.immutable.ImmutableTupleBoolean;
import data_structures.tuple.mutable.TupleBoolean;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorBoolean implements Iterator<Boolean> {
    private final TupleBoolean tuple;
    private final ImmutableTupleBoolean imtuple;
    private int p;

    public TupleIteratorBoolean(TupleBoolean tuple) {
        this.tuple = tuple;
        this.imtuple = null;
        this.p = 0;
    }

    public TupleIteratorBoolean(ImmutableTupleBoolean tuple) {
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
    public Boolean next() {
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
