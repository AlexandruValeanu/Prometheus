package data_structures.tuple.iterators;

import data_structures.tuple.immutable.ImmutableTupleByte;
import data_structures.tuple.mutable.TupleByte;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorByte implements Iterator<Byte> {
    private final TupleByte tuple;
    private final ImmutableTupleByte imtuple;
    private int p;

    public TupleIteratorByte(TupleByte tuple) {
        this.tuple = tuple;
        this.imtuple = null;
        this.p = 0;
    }

    public TupleIteratorByte(ImmutableTupleByte tuple) {
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
    public Byte next() {
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
