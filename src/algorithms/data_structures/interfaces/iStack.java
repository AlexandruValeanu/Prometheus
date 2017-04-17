package algorithms.data_structures.interfaces;

public interface iStack<E>  {
    public E push(E item);
    public E pop();
    public E peek();
    public int size();
    public boolean isEmpty();
    public boolean isNonEmpty();
}
