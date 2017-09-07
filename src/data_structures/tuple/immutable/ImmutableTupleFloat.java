package data_structures.tuple.immutable;

import com.google.common.primitives.Floats;
import data_structures.tuple.iterators.TupleIteratorFloat;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ImmutableTupleFloat implements Iterable<Float>, Comparable<ImmutableTupleFloat> {
    private float[] elems;
    public final int length;

    public ImmutableTupleFloat(float... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public float get(int index){
        return elems[index];
    }


    @Override
    public int compareTo(@NotNull ImmutableTupleFloat o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTupleFloat that = (ImmutableTupleFloat) o;
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

    private static ImmutableTupleFloat ImmutableTupleFloatEmpty = new ImmutableTupleFloat();

    public static ImmutableTupleFloat valueOf(float... elements){
        if (elements == null)
            return ImmutableTupleFloatEmpty;
        else
            return new ImmutableTupleFloat(elements);
    }
}
