package data_structures;

import data_structures.exceptions.EmptyQueueException;
import data_structures.interfaces.iQueue;

import java.util.Comparator;

public class MinQueue<E> implements iQueue<E> {
    final private MinStack<E> oldStack, newStack;
    final private Comparator<? super E> comparator;

    public MinQueue(Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.oldStack = new MinStack<>(comparator);
        this.newStack = new MinStack<>(comparator);
    }

    public E minimum(){
        if (isEmpty())
            throw new EmptyQueueException();

        if (oldStack.isEmpty())
            return newStack.minimum();
        else if (newStack.isEmpty())
            return oldStack.minimum();
        else{
            int cmp = comparator.compare(oldStack.minimum(), newStack.minimum());

            if (cmp < 0)
                return oldStack.minimum();
            else
                return newStack.minimum();
        }
    }

    @Override
    public void add(E item) {
        newStack.add(item);
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new EmptyQueueException();

        moveIfNecessary();
        return oldStack.pop();
    }

    @Override
    public E front() {
        if (isEmpty())
            throw new EmptyQueueException();

        moveIfNecessary();
        return oldStack.top();
    }

    @Override
    public int size() {
        return oldStack.size() + newStack.size();
    }

    @Override
    public boolean isEmpty() {
        return oldStack.isEmpty() && newStack.isEmpty();
    }

    Comparator<? super E> comparator(){
        return comparator;
    }

    private void moveIfNecessary(){
        if (oldStack.isEmpty()){
            while (!newStack.isEmpty()){
                oldStack.add(newStack.pop());
            }
        }
    }
}
