package data_structures.tuple.immutable;

import com.google.common.primitives.Chars;
import data_structures.tuple.iterators.TupleIteratorChar;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ImmutableTupleChar implements Iterable<Character>, Comparable<ImmutableTupleChar> {
    private char[] elems;
    public final int length;

    public ImmutableTupleChar(char... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public char get(int index){
        return elems[index];
    }

    @Override
    public int compareTo(@NotNull ImmutableTupleChar o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTupleChar that = (ImmutableTupleChar) o;
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

    public char[] toArray(){
        return elems.clone();
    }

    public List<Character> toList(){
        return Chars.asList(elems);
    }

    @NotNull
    @Override
    public Iterator<Character> iterator() {
        return new TupleIteratorChar(this);
    }

    /// static methods

    private static ImmutableTupleChar ImmutableTupleCharEmpty = new ImmutableTupleChar();

    public static ImmutableTupleChar valueOf(char... elements){
        if (elements == null)
            return ImmutableTupleCharEmpty;
        else
            return new ImmutableTupleChar(elements);
    }
}
