package data_structures.interfaces;

public interface iStack<E> {
    void add(E item);
    E pop();
    E top();
    int size();
    boolean isEmpty();
}
