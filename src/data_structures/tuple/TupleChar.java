package data_structures.tuple;

import data_structures.tuple.iterators.TupleIteratorChar;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TupleChar implements Iterable<Character> {
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

    public final TupleChar add(char... elements){
        return new TupleChar(ArrayUtils.addAll(elems, elements));
    }

    public char[] toArray(){
        return elems.clone();
    }

    @NotNull
    @Override
    public Iterator<Character> iterator() {
        return new TupleIteratorChar(this);
    }
}
