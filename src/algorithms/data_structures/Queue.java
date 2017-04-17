package algorithms.data_structures;

import algorithms.data_structures.exceptions.EmptyQueueException;
import algorithms.data_structures.interfaces.iQueue;

import java.util.ArrayDeque;

// TODO add documentation

public class Queue<E> implements iQueue<E> {
    private final ArrayDeque<E> list = new ArrayDeque<>();

    @Override
    public E push(E item) {
        list.addLast(item);
        return list.peekLast();
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new EmptyQueueException("Queue::pop");

        return list.pollFirst();
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new EmptyQueueException("Queue::peek");

        return list.peekFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isNonEmpty() {
        return !list.isEmpty();
    }
}
