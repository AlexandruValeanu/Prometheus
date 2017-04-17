package data_structures.interfaces;

public interface iQueue<E> {
    public E push(E item);
    public E pop();
    public E peek();
    public int size();
    public boolean isEmpty();
    public boolean isNonEmpty();
}
