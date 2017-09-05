package data_structures.tuple;

import data_structures.tuple.iterators.TupleIteratorFloat;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TupleFloat implements Iterable<Float> {
    private float[] elems;
    public final int length;

    public TupleFloat(float... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, float element){
        elems[index] = element;
    }

    public float get(int index){
        return elems[index];
    }

    public final TupleFloat add(float... elements){
        return new TupleFloat(ArrayUtils.addAll(elems, elements));
    }

    public float[] toArray(){
        return elems.clone();
    }

    @NotNull
    @Override
    public Iterator<Float> iterator() {
        return new TupleIteratorFloat(this);
    }
}
