package data_structures.tuple.iterators;

import data_structures.tuple.immutable.ImmutableTupleFloat;
import data_structures.tuple.mutable.TupleFloat;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorFloat implements Iterator<Float> {
    private final TupleFloat tuple;
    private final ImmutableTupleFloat imtuple;
    private int p;

    public TupleIteratorFloat(TupleFloat tuple) {
        this.tuple = tuple;
        this.imtuple = null;
        this.p = 0;
    }

    public TupleIteratorFloat(ImmutableTupleFloat tuple) {
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
    public Float next() {
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
