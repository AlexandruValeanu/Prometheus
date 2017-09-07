package data_structures.tuple.mutable;

import com.google.common.primitives.Ints;
import data_structures.tuple.iterators.TupleIteratorInt;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TupleInt implements Iterable<Integer>, Comparable<TupleInt> {
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

    @Override
    public int compareTo(@NotNull TupleInt o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TupleInt that = (TupleInt) o;
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

    public int[] toArray(){
        return elems.clone();
    }

    public List<Integer> toList(){
        return Ints.asList(elems);
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new TupleIteratorInt(this);
    }

    /// static methods

    public static TupleInt TupleIntEmpty = new TupleInt();

    public static TupleInt valueOf(int... elements){
        if (elements == null)
            return TupleIntEmpty;
        else
            return new TupleInt(elements);
    }
}
