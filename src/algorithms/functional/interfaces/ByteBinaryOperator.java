package algorithms.functional.interfaces;

@FunctionalInterface
public interface ByteBinaryOperator {
    /**
     * Applies this operator to the given operands.
     *
     * @param left the first operand
     * @param right the second operand
     * @return the operator result
     */
    byte applyAsByte(byte left, byte right);
}
