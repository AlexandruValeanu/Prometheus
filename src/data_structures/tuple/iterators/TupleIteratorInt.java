package data_structures.tuple.iterators;

import data_structures.tuple.immutable.ImmutableTupleInt;
import data_structures.tuple.mutable.TupleInt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorInt implements Iterator<Integer> {
    private final TupleInt tuple;
    private final ImmutableTupleInt imtuple;
    private int p;

    public TupleIteratorInt(TupleInt tuple) {
        this.tuple = tuple;
        this.imtuple = null;
        this.p = 0;
    }

    public TupleIteratorInt(ImmutableTupleInt tuple) {
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
    public Integer next() {
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
