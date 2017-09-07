package data_structures.tuple.mutable;

import com.google.common.primitives.Shorts;
import data_structures.tuple.iterators.TupleIteratorShort;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TupleShort implements Iterable<Short>, Comparable<TupleShort> {
    private short[] elems;
    public int length;

    public TupleShort(short... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, short elem){
        elems[index] = elem;
    }

    public short get(int index){
        return elems[index];
    }

    @Override
    public int compareTo(@NotNull TupleShort o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TupleShort that = (TupleShort) o;
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

    public short[] toArray(){
        return elems.clone();
    }

    public List<Short> toList(){
        return Shorts.asList(elems);
    }

    @NotNull
    @Override
    public Iterator<Short> iterator() {
        return new TupleIteratorShort(this);
    }

    /// static methods

    public static TupleShort TupleShortEmpty = new TupleShort();

    public static TupleShort valueOf(short... elements){
        if (elements == null)
            return TupleShortEmpty;
        else
            return new TupleShort(elements);
    }
}
