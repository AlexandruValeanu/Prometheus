package data_structures.tuple.iterators;

import data_structures.tuple.immutable.ImmutableTupleLong;
import data_structures.tuple.mutable.TupleLong;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorLong implements Iterator<Long> {
    private final TupleLong tuple;
    private final ImmutableTupleLong imtuple;
    private int p;

    public TupleIteratorLong(TupleLong tuple) {
        this.tuple = tuple;
        this.imtuple = null;
        this.p = 0;
    }

    public TupleIteratorLong(ImmutableTupleLong tuple) {
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
    public Long next() {
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
