package data_structures.exceptions;

public class EmptyPriorityQueueException extends RuntimeException {
    private final String message;

    /**
     * Constructs a new <code>EmptyPriorityQueueException</code> with <tt>null</tt>
     * as its error message string.
     */
    public EmptyPriorityQueueException(){
        this.message = null;
    }

    /**
     * Constructs a new <code>EmptyPriorityQueueException</code> with <tt>message</tt>
     * as its error message string.
     * @param message  message passed to the exception
     */
    public EmptyPriorityQueueException(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmptyPriorityQueueException: " + message;
    }
}

