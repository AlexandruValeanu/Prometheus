package data_structures.tuple.immutable;

import com.google.common.primitives.Booleans;
import data_structures.tuple.iterators.TupleIteratorBoolean;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ImmutableTupleBoolean implements Iterable<Boolean>, Comparable<ImmutableTupleBoolean> {
    private boolean[] elems;
    public final int length;

    public ImmutableTupleBoolean(boolean... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public boolean get(int index){
        return elems[index];
    }

    public final ImmutableTupleBoolean add(boolean... elements){
        return new ImmutableTupleBoolean(ArrayUtils.addAll(elems, elements));
    }

    @Override
    public int compareTo(@NotNull ImmutableTupleBoolean o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTupleBoolean booleans = (ImmutableTupleBoolean) o;
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

    public static ImmutableTupleBoolean ImmutableTupleBooleanEmpty = new ImmutableTupleBoolean();

    public static ImmutableTupleBoolean of(boolean... elements){
        if (elements == null)
            return ImmutableTupleBooleanEmpty;
        else
            return new ImmutableTupleBoolean(elements);
    }
}
