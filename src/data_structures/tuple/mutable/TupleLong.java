package data_structures.tuple.mutable;

import com.google.common.primitives.Longs;
import data_structures.tuple.iterators.TupleIteratorLong;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TupleLong implements Iterable<Long>, Comparable<TupleLong> {
    private long[] elems;
    public int length;

    public TupleLong(long... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, long elem){
        elems[index] = elem;
    }

    public long get(int index){
        return elems[index];
    }

    @Override
    public int compareTo(@NotNull TupleLong o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TupleLong that = (TupleLong) o;
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

    public long[] toArray(){
        return elems.clone();
    }

    public List<Long> toList(){
        return Longs.asList(elems);
    }

    @NotNull
    @Override
    public Iterator<Long> iterator() {
        return new TupleIteratorLong(this);
    }

    /// static methods

    public static TupleLong TupleLongEmpty = new TupleLong();

    public static TupleLong valueOf(long... elements){
        if (elements == null)
            return TupleLongEmpty;
        else
            return new TupleLong(elements);
    }
}
