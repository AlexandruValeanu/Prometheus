package data_structures.tuple.mutable;

import com.google.common.primitives.Bytes;
import data_structures.tuple.iterators.TupleIteratorByte;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TupleByte implements Iterable<Byte>, Comparable<TupleByte> {
    private byte[] elems;
    public final int length;

    public TupleByte(byte... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public void set(int index, byte element){
        elems[index] = element;
    }

    public byte get(int index){
        return elems[index];
    }

    @Override
    public int compareTo(@NotNull TupleByte o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TupleByte that = (TupleByte) o;
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

    public byte[] toArray(){
        return elems.clone();
    }

    public List<Byte> toList(){
        return Bytes.asList(elems);
    }

    @NotNull
    @Override
    public Iterator<Byte> iterator() {
        return new TupleIteratorByte(this);
    }

    /// static methods

    public static TupleByte TupleByteEmpty = new TupleByte();

    public static TupleByte valueOf(byte... elements){
        if (elements == null)
            return TupleByteEmpty;
        else
            return new TupleByte(elements);
    }
}
