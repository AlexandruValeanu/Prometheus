package data_structures.tuple.iterators;

import data_structures.tuple.immutable.ImmutableTupleChar;
import data_structures.tuple.mutable.TupleChar;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorChar implements Iterator<Character> {
    private final TupleChar tuple;
    private final ImmutableTupleChar imtuple;
    private int p;

    public TupleIteratorChar(TupleChar tuple) {
        this.tuple = tuple;
        this.imtuple = null;
        this.p = 0;
    }

    public TupleIteratorChar(ImmutableTupleChar tuple) {
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
    public Character next() {
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
