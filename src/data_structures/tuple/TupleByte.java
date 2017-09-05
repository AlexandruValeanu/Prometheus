package data_structures.tuple;

import data_structures.tuple.iterators.TupleIteratorByte;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TupleByte implements Iterable<Byte> {
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

    public final TupleByte add(byte... elements){
        return new TupleByte(ArrayUtils.addAll(elems, elements));
    }

    public byte[] toArray(){
        return elems.clone();
    }

    @NotNull
    @Override
    public Iterator<Byte> iterator() {
        return new TupleIteratorByte(this);
    }
}
