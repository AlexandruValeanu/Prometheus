package algorithms.functional.interfaces;

@FunctionalInterface
public interface BooleanBinaryOperator {
    /**
     * Applies this operator to the given operands.
     *
     * @param left the first operand
     * @param right the second operand
     * @return the operator result
     */
    boolean applyAsBoolean(boolean left, boolean right);
}
