package data_structures.tuple.mutable;

import com.google.common.primitives.Doubles;
import data_structures.tuple.iterators.TupleIteratorDouble;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TupleDouble implements Iterable<Double>, Comparable<TupleDouble> {
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

    @Override
    public int compareTo(@NotNull TupleDouble o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TupleDouble that = (TupleDouble) o;
        return Arrays.equals(elems, that.elems);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elems);
    }

    @Override
    public String toString() {
        return Arrays.toString(elems);
    }

    public double[] toArray(){
        return elems.clone();
    }

    public List<Double> toList(){
        return Doubles.asList(elems);
    }

    @NotNull
    @Override
    public Iterator<Double> iterator() {
        return new TupleIteratorDouble(this);
    }

    /// static methods

    public static TupleDouble TupleDoubleEmpty = new TupleDouble();

    public static TupleDouble valueOf(double... elements){
        if (elements == null)
            return TupleDoubleEmpty;
        else
            return new TupleDouble(elements);
    }
}
