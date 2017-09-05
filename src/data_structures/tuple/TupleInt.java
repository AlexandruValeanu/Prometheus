package data_structures.tuple;

import data_structures.tuple.iterators.TupleIteratorInt;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TupleInt implements Iterable<Integer> {
    private int[] elems;
    public int length;

    public TupleInt(int... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, int elem){
        elems[index] = elem;
    }

    public int get(int index){
        return elems[index];
    }

    @NotNull
    public final TupleInt add(int... elements){
        return new TupleInt(ArrayUtils.addAll(elems, elements));
    }

    public int[] toArray(){
        return elems.clone();
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new TupleIteratorInt(this);
    }
}
