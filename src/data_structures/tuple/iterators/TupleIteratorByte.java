package data_structures.tuple.iterators;

import data_structures.tuple.TupleByte;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleIteratorByte implements Iterator<Byte> {
    private final TupleByte tuple;
    private int p;

    public TupleIteratorByte(TupleByte tuple) {
        this.tuple = tuple;
        this.p = 0;
    }

    @Override
    public boolean hasNext() {
        return p < tuple.length;
    }

    @Override
    public Byte next() {
        if (this.hasNext()){
            return tuple.get(p++);
        }

        throw new NoSuchElementException("tuple");
    }
}
