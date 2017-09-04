package data_structures.tuple;

import data_structures.tuple.iterators.TupleLongIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TupleLong implements Iterable<Long> {
    private long[] elems;

    public TupleLong(long... elements) {
        this.elems = elements;
    }

    public void set(int index, long elem){
        elems[index] = elem;
    }

    public long get(int index){
        return elems[index];
    }

    public int length(){
        return elems.length;
    }

    @NotNull
    @Override
    public Iterator<Long> iterator() {
        return new TupleLongIterator(this);
    }
}
