package data_structures.tuple;

import data_structures.tuple.iterators.TupleDoubleIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TupleDouble implements Iterable<Double> {
    private double[] elems;

    public TupleDouble(double... elements) {
        this.elems = elements;
    }

    void set(int index, double elem){
        elems[index] = elem;
    }

    public double get(int index){
        return elems[index];
    }

    public int length(){
        return elems.length;
    }

    @NotNull
    @Override
    public Iterator<Double> iterator() {
        return new TupleDoubleIterator(this);
    }
}
