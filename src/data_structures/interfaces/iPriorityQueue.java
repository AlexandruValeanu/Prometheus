package data_structures.interfaces;

import java.util.Comparator;
import java.util.Queue;

public interface iPriorityQueue<E> extends iQueue<E> {
    E findMin();
    E extractMin();

    int size();
    boolean isEmpty();

    Comparator<? super E> comparator();

    java.util.Collection<E> toCollection();
    iPriorityQueue<E> merge(iPriorityQueue<E> otherPQ);
}
