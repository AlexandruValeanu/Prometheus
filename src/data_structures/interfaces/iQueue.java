package data_structures.interfaces;

public interface iQueue<E> {
    void add(E item);
    E pop();
    E front();
    int size();
    boolean isEmpty();
}
