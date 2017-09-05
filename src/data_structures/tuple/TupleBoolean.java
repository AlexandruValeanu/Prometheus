package data_structures.tuple;

import data_structures.tuple.iterators.TupleIteratorBoolean;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TupleBoolean implements Iterable<Boolean> {
    private boolean[] elems;
    public final int length;

    public TupleBoolean(boolean... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, boolean element){
        elems[index] = element;
    }

    public boolean get(int index){
        return elems[index];
    }

    public final TupleBoolean add(boolean... elements){
        return new TupleBoolean(ArrayUtils.addAll(elems, elements));
    }

    public boolean[] toArray(){
        return elems.clone();
    }

    @NotNull
    @Override
    public Iterator<Boolean> iterator() {
        return new TupleIteratorBoolean(this);
    }
}
