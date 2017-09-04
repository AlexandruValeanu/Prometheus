package data_structures.tuple;

import data_structures.tuple.iterators.TupleCharIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class TupleChar implements Iterable<Character> {
    private char[] elems;

    public TupleChar(char... elements) {
        this.elems = elements;
    }

    public void set(int index, char elem){
        elems[index] = elem;
    }

    public char get(int index){
        return elems[index];
    }

    public int length(){
        return elems.length;
    }

    @NotNull
    @Override
    public Iterator<Character> iterator() {
        return new TupleCharIterator(this);
    }
}
