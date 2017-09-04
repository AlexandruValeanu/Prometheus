package data_structures.tuple;

import data_structures.tuple.iterators.TupleIntIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TupleInt implements Iterable<Integer> {
    private int[] elems;

    public TupleInt(int... elements) {
        this.elems = elements;
    }

    public void set(int index, int elem){
        elems[index] = elem;
    }

    public int get(int index){
        return elems[index];
    }

    public int length(){
        return elems.length;
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new TupleIntIterator(this);
    }
}
