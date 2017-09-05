package data_structures.tuple;

import data_structures.tuple.iterators.TupleIteratorDouble;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TupleDouble implements Iterable<Double> {
    private double[] elems;
    public final int length;

    public TupleDouble(double... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, double element){
        elems[index] = element;
    }

    public double get(int index){
        return elems[index];
    }

    public final TupleDouble add(double... elements){
        return new TupleDouble(ArrayUtils.addAll(elems, elements));
    }

    public double[] toArray(){
        return elems.clone();
    }

    @NotNull
    @Override
    public Iterator<Double> iterator() {
        return new TupleIteratorDouble(this);
    }
}
