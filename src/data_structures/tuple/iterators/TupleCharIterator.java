package data_structures.tuple.iterators;

import data_structures.tuple.TupleChar;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TupleCharIterator implements Iterator<Character> {
    private final TupleChar tuple;
    private int p;

    public TupleCharIterator(TupleChar tuple) {
        this.tuple = tuple;
        this.p = 0;
    }

    @Override
    public boolean hasNext() {
        return p < tuple.length();
    }

    @Override
    public Character next() {
        if (this.hasNext()){
            return tuple.get(p++);
        }

        throw new NoSuchElementException("tuple");
    }
}
