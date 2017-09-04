package data_structures.tuple;

import data_structures.tuple.iterators.TupleIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Tuple<E> implements Iterable<E> {
    private E[] elems;

    @SafeVarargs
    public Tuple(E... elements) {
        this.elems = elements;
    }

    public void set(int index, E elem){
        elems[index] = elem;
    }

    public E get(int index){
        return elems[index];
    }

    public int length(){
        return elems.length;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new TupleIterator<>(this);
    }
}
