package data_structures.tuple;

import data_structures.tuple.iterators.TupleIteratorInt;
import data_structures.tuple.iterators.TupleIteratorShort;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TupleShort implements Iterable<Short> {
    private short[] elems;
    public int length;

    public TupleShort(short... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, short elem){
        elems[index] = elem;
    }

    public short get(int index){
        return elems[index];
    }

    public final TupleShort add(short... elements){
        return new TupleShort(ArrayUtils.addAll(elems, elements));
    }

    public short[] toArray(){
        return elems.clone();
    }

    @NotNull
    @Override
    public Iterator<Short> iterator() {
        return new TupleIteratorShort(this);
    }
}
