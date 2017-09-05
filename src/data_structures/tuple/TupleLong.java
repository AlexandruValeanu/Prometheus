package data_structures.tuple;

import data_structures.tuple.iterators.TupleIteratorLong;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TupleLong implements Iterable<Long> {
    private long[] elems;
    public int length;

    public TupleLong(long... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, long elem){
        elems[index] = elem;
    }

    public long get(int index){
        return elems[index];
    }

    @NotNull
    public final TupleLong add(long... elements){
        return new TupleLong(ArrayUtils.addAll(elems, elements));
    }

    public long[] toArray(){
        return elems.clone();
    }

    @NotNull
    @Override
    public Iterator<Long> iterator() {
        return new TupleIteratorLong(this);
    }
}
