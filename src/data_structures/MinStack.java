package data_structures;

import data_structures.interfaces.iStack;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;

public class MinStack<E> implements iStack<E> {
    final private ArrayDeque<E> stack = new ArrayDeque<>();
    final private ArrayDeque<E> minStack = new ArrayDeque<>();
    final private Comparator<? super E> comparator;

    public MinStack(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public E minimum(){
        if (isEmpty())
            throw new EmptyStackException();

        return minStack.peekLast();
    }

    @Override
    public void add(E item) {
        if (minStack.isEmpty())
            minStack.addLast(item);
        else{
            int cmp = comparator.compare(item, minStack.getLast());

            if (cmp < 0)
                minStack.addLast(item);
            else
                minStack.addLast(minStack.getLast());
        }

        stack.addLast(item);
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();

        minStack.pollLast();
        return stack.pollLast();
    }

    @Override
    public E top() {
        if (isEmpty())
            throw new EmptyStackException();

        return stack.peekLast();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    Comparator<? super E> comparator(){
        return comparator;
    }
}
