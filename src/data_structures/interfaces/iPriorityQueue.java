package data_structures.interfaces;

import java.util.Comparator;

public interface iPriorityQueue<E> {
    public void add(E item);
    public E findMin();
    public E extractMin();

    public int size();
    public boolean isEmpty();
    public boolean isNonEmpty();

    public Comparator<? super E> comparator();

    public java.util.Collection<E> toCollection();
    public iPriorityQueue<E> merge (iPriorityQueue<E> otherPQ);
}
