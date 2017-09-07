package data_structures.tuple.immutable;

import com.google.common.primitives.Bytes;
import data_structures.tuple.iterators.TupleIteratorByte;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ImmutableTupleByte implements Iterable<Byte>, Comparable<ImmutableTupleByte> {
    private byte[] elems;
    public final int length;

    public ImmutableTupleByte(byte... elements) {
        this.elems = elements;
        this.length = ArrayUtils.getLength(this.elems);
    }

    public byte get(int index){
        return elems[index];
    }

    public final ImmutableTupleByte add(byte... elements){
        return new ImmutableTupleByte(ArrayUtils.addAll(elems, elements));
    }

    @Override
    public int compareTo(@NotNull ImmutableTupleByte o) {
        return Arrays.compare(elems, o.elems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableTupleByte that = (ImmutableTupleByte) o;
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

    public static ImmutableTupleByte ImmutableTupleByteEmpty = new ImmutableTupleByte();

    public static ImmutableTupleByte valueOf(byte... elements){
        if (elements == null)
            return ImmutableTupleByteEmpty;
        else
            return new ImmutableTupleByte(elements);
    }
}
