package data_structures.priority_queues;

import algorithms.Algorithms;
import data_structures.exceptions.EmptyPriorityQueueException;
import data_structures.interfaces.iPriorityQueue;
import jdk.nashorn.internal.ir.BinaryNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class BinaryHeap<E> implements iPriorityQueue<E> {
    private final Comparator<? super E> comparator;
    private Object[] queue = new Object[1];
    private int N = 0;

    public BinaryHeap(Collection<? extends E> c, Comparator<? super E> comparator){
        this.comparator = comparator;
        this.N = 0;

        if (c == null)
            ensureCapacity(DEFAULT_INITIAL_CAPACITY);
        else
            ensureCapacity(Math.min(DEFAULT_INITIAL_CAPACITY, c.size()));

        if (c != null)
            makeHeap(c);
    }

    public BinaryHeap(Comparator<? super E> comparator){
        this(null, comparator);
    }

    @Override
    public void add(E item) {
        N++;
        ensureCapacity(N);
        this.queue[N - 1] = item;
        upHeap(N - 1);
    }

    @Override
    public E pop() {
        return extractMin();
    }

    @Override
    public E front() {
        return findMin();
    }

    @Override
    @SuppressWarnings("unchecked expression")
    public E findMin() {
        if (isEmpty())
            throw new EmptyPriorityQueueException();

        return (E)queue[0];
    }

    @Override
    @SuppressWarnings("unchecked expression")
    public E extractMin() {
        if (isEmpty())
            throw new EmptyPriorityQueueException();

        E elem = (E)queue[0];
        queue[0] = null;
        N--;

        if (N > 0) {
            queue[0] = queue[N];
            queue[N] = null;
        }

        downHeap(0);
        return elem;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Comparator<? super E> comparator() {
        return comparator;
    }

    @Override
    @SuppressWarnings("unchecked expression")
    public Collection<E> toCollection() {
        java.util.Collection<E> collection = new ArrayList<>();

        for (int i = 0; i < this.N; i++) {
            collection.add((E)queue[i]);
        }

        return collection;
    }

    @Override
    public iPriorityQueue<E> merge(iPriorityQueue<E> other) {
        java.util.Collection<E> collection = this.toCollection();
        collection.addAll(other.toCollection());
        return new BinaryHeap<>(collection, this.comparator());
    }

    /* Implementation below this point */
    private final int DEFAULT_INITIAL_CAPACITY = 11;

    private void grow(){
        int oldCapacity = queue.length;

        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));

        queue = Arrays.copyOf(queue, newCapacity);
    }

    private void ensureCapacity(int requestedCapacity){
        while (queue.length < requestedCapacity)
            grow();
    }

    private static int father(int node){
        return (node - 1) / 2;
    }

    private static int leftSon(int node){
        return 2 * node + 1;
    }

    private static int rightSon(int node){
        return 2 * node + 2;
    }

    @SuppressWarnings("unchecked expression")
    private boolean less(Object x, Object y){
        return comparator.compare((E)x, (E)y) < 0;
    }

    private void makeHeap(Collection<? extends E> c){
        N = 0;
        c.forEach(x -> queue[N++] = x);

        for (int j = N / 2 - 1; j >= 0; j--) {
            downHeap(j);
        }
    }

    @SuppressWarnings("unchecked expression")
    private void upHeap(int pos){
        while (pos > 0 && less(queue[pos], queue[father(pos)])){
            Algorithms.swap(queue, pos, father(pos));
            pos = father(pos);
        }
    }

    @SuppressWarnings("unchecked expression")
    private void downHeap(int pos){
        while (leftSon(pos) < N){
            int j = leftSon(pos);
            int rs = rightSon(pos);

            if (rs < N && less(queue[rs], queue[j]))
                j = rs;

            if (less(queue[j], queue[pos])){
                Algorithms.swap(queue, j, pos);
                pos = j;
            }
            else break;
        }
    }
}
