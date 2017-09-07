package data_structures.tuple.mutable;

import com.google.common.primitives.Floats;
import data_structures.tuple.iterators.TupleIteratorFloat;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TupleFloat implements Iterable<Float>, Comparable<TupleFloat> {
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

    @Override
    public int compareTo(@NotNull TupleFloat o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TupleFloat that = (TupleFloat) o;
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

    public float[] toArray(){
        return elems.clone();
    }

    public List<Float> toList(){
        return Floats.asList(elems);
    }

    @NotNull
    @Override
    public Iterator<Float> iterator() {
        return new TupleIteratorFloat(this);
    }

    /// static methods

    public static TupleFloat TupleFloatEmpty = new TupleFloat();

    public static TupleFloat valueOf(float... elements){
        if (elements == null)
            return TupleFloatEmpty;
        else
            return new TupleFloat(elements);
    }
}
