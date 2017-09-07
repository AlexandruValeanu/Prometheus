package data_structures.tuple.immutable;

import com.google.common.primitives.Doubles;
import data_structures.tuple.iterators.TupleIteratorDouble;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ImmutableTupleDouble implements Iterable<Double>, Comparable<ImmutableTupleDouble> {
    private double[] elems;
    public final int length;

    public ImmutableTupleDouble(double... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public double get(int index){
        return elems[index];
    }

    @Override
    public int compareTo(@NotNull ImmutableTupleDouble o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTupleDouble that = (ImmutableTupleDouble) o;
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

    private static ImmutableTupleDouble ImmutableTupleDoubleEmpty = new ImmutableTupleDouble();

    public static ImmutableTupleDouble valueOf(double... elements){
        if (elements == null)
            return ImmutableTupleDoubleEmpty;
        else
            return new ImmutableTupleDouble(elements);
    }
}
