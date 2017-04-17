package data_structures.exceptions;


public class EmptyQueueException extends RuntimeException {
    private final String message;

    /**
     * Constructs a new <code>EmptyQueueException</code> with <tt>null</tt>
     * as its error message string.
     */
    public EmptyQueueException(){
        this.message = null;
    }

    /**
     * Constructs a new <code>EmptyQueueException</code> with <tt>message</tt>
     * as its error message string.
     * @param message  message passed to the exception
     */
    public EmptyQueueException(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmptyQueueException: " + message;
    }
}
