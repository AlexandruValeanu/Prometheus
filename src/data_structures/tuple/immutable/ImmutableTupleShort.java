package data_structures.tuple.immutable;

import com.google.common.primitives.Shorts;
import data_structures.tuple.iterators.TupleIteratorShort;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ImmutableTupleShort implements Iterable<Short>, Comparable<ImmutableTupleShort> {
    private short[] elems;
    public int length;

    public ImmutableTupleShort(short... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public short get(int index){
        return elems[index];
    }

    @Override
    public int compareTo(@NotNull ImmutableTupleShort o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTupleShort that = (ImmutableTupleShort) o;
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

    private static ImmutableTupleShort ImmutableTupleShortEmpty = new ImmutableTupleShort();

    public static ImmutableTupleShort valueOf(short... elements){
        if (elements == null)
            return ImmutableTupleShortEmpty;
        else
            return new ImmutableTupleShort(elements);
    }
}
