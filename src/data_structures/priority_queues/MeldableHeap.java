package data_structures.priority_queues;

import data_structures.exceptions.EmptyPriorityQueueException;
import data_structures.interfaces.iPriorityQueue;

import java.util.*;

public class MeldableHeap<E> implements iPriorityQueue<E> {
    final private static Random random = new Random();
    final private Comparator<? super E> comparator;

    private MeldableHeap(Node root, Comparator<? super E> comparator) {
        this.root = root;
        this.comparator = comparator;
    }

    public MeldableHeap(Comparator<? super E> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    public MeldableHeap(Collection<? extends E> c, Comparator<? super E> comparator){
        this.root = null;
        this.comparator = comparator;
        c.forEach(this::add);
    }

    @Override
    public void add(E item) {
        this.root = merge(root, new Node(item));
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
    public E findMin() {
        if (isEmpty())
            throw new EmptyPriorityQueueException();

        return root.key;
    }

    @Override
    public E extractMin() {
        if (isEmpty())
            throw new EmptyPriorityQueueException();

        E item = root.key;
        root = merge(root.left, root.right);
        return item;
    }

    @Override
    public int size() {
        return root == null ? 0 : root.size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Comparator<? super E> comparator() {
        return comparator;
    }

    @Override
    public Collection<E> toCollection() {
        Collection<E> collection = new ArrayList<>();
        dfs(root, collection);
        return collection;
    }

    public iPriorityQueue<E> merge(iPriorityQueue<E> otherPQ) {
        if (otherPQ instanceof MeldableHeap){
            return new MeldableHeap<>(merge(this.root, ((MeldableHeap<E>)otherPQ).root), comparator);
        }
        else{
            java.util.Collection<E> collection = this.toCollection();
            collection.addAll(otherPQ.toCollection());
            return new MeldableHeap<>(collection, this.comparator());
        }
    }

    /* Implementation below this point */
    private class Node{
        E key;
        Node left, right;
        int size = 0;

        Node(E key) {
            this.key = key;
            this.size = 1;
        }
    }

    private Node root;

    private Node merge(Node a, Node b) {
        if (a == null)
            return b;

        if (b == null)
            return a;

        int cmp = comparator.compare(a.key, b.key);

        if (cmp > 0) {
            Node t = a;
            a = b;
            b = t;
        }

        if (random.nextBoolean()) {
            Node t = a.left;
            a.left = a.right;
            a.right = t;
        }

        a.left = merge(a.left, b);
        a.size += b.size;

        return a;
    }

    private void dfs(Node node, Collection<E> collection){
        if (node != null){
            collection.add(node.key);
            dfs(node.left, collection);
            dfs(node.right, collection);
        }
    }
}
