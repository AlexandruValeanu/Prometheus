package data_structures.tuple.mutable;

import com.google.common.primitives.Chars;
import data_structures.tuple.iterators.TupleIteratorChar;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TupleChar implements Iterable<Character>, Comparable<TupleChar> {
    private char[] elems;
    public final int length;

    public TupleChar(char... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, char element){
        elems[index] = element;
    }

    public char get(int index){
        return elems[index];
    }

    @Override
    public int compareTo(@NotNull TupleChar o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TupleChar that = (TupleChar) o;
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

    public static TupleChar TupleCharEmpty = new TupleChar();

    public static TupleChar valueOf(char... elements){
        if (elements == null)
            return TupleCharEmpty;
        else
            return new TupleChar(elements);
    }
}
