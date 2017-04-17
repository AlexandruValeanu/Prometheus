package algorithms.data_structures;

import algorithms.data_structures.interfaces.iStack;

import java.util.*;

/**
 * The <code>Stack</code> class represents a last-in-first-out
 * (LIFO) stack of objects. The usual <tt>push</tt> and <tt>pop</tt> operations
 * are provided, as well as a method to <tt>peek</tt> at the top item on the stack,
 * a method to test for whether the stack is <tt>empty</tt> and a method to find its <tt>size</tt>.
 * <p>
 * When a stack is first created, it contains no items.
 *
 * <p>
 * A stack can also be created from a collection.
 *
 * @author  Alexandru Valeanu
 */
public class Stack<E> implements iStack<E> {
    private final List<E> stack = new ArrayList<>();

    /**
     * Creates an empty Stack.
     */
    public Stack(){
    }

    /**
     * Creates a stack from a collection.
     */
    public Stack(Collection<? extends E> collection){
        collection.forEach(this::push);
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param   item   the item to be pushed onto this stack.
     * @return  the <code>item</code> argument.
     * @throws  EmptyStackException  if this stack is empty.
     */
    public E push(E item){
        stack.add(item);
        return item;
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return  The object at the top of this stack (the last item inserted)
     * @throws  EmptyStackException  if this stack is empty.
     */
    public E pop(){
        if (stack.isEmpty())
            throw new EmptyStackException();

        return stack.remove(stack.size() - 1);
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return  the object at the top of this stack (the last item inserted)
     * @throws  EmptyStackException  if this stack is empty.
     */
    public E peek(){
        if (stack.isEmpty())
            throw new EmptyStackException();

        return stack.get(stack.size() - 1);
    }

    /**
     * Finds the number of elements in the stack.
     *
     * @return  the number of elements in the stack
     */
    public int size(){
        return stack.size();
    }

    /**
     * Tests if this stack is empty.
     *
     * @return  <code>true</code> if and only if this stack contains
     *          no items; <code>false</code> otherwise.
     */
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    /**
     * Tests if this stack is not empty.
     *
     * @return  <code>false</code> if and only if this stack contains
     *          no items; <code>true</code> otherwise.
     */
    public boolean isNonEmpty(){
        return !stack.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stack)) return false;
        Stack<?> stack1 = (Stack<?>) o;
        return Objects.equals(stack, stack1.stack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stack);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + stack +
                '}';
    }
}
