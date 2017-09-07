package data_structures.tuple.mutable;

import com.google.common.primitives.Booleans;
import data_structures.tuple.iterators.TupleIteratorBoolean;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TupleBoolean implements Iterable<Boolean>, Comparable<TupleBoolean> {
    private boolean[] elems;
    public final int length;

    public TupleBoolean(boolean... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, boolean element){
        elems[index] = element;
    }

    public boolean get(int index){
        return elems[index];
    }

    @Override
    public int compareTo(@NotNull TupleBoolean o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TupleBoolean booleans = (TupleBoolean) o;
        return Arrays.equals(elems, booleans.elems);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elems);
    }

    @Override
    public String toString() {
        return Arrays.toString(elems);
    }

    public boolean[] toArray(){
        return elems.clone();
    }

    public List<Boolean> toList(){
        return Booleans.asList(elems);
    }

    @NotNull
    @Override
    public Iterator<Boolean> iterator() {
        return new TupleIteratorBoolean(this);
    }

    /// static methods

    public static TupleBoolean TupleBooleanEmpty = new TupleBoolean();

    public static TupleBoolean valueOf(boolean... elements){
        if (elements == null)
            return TupleBooleanEmpty;
        else
            return new TupleBoolean(elements);
    }
}
