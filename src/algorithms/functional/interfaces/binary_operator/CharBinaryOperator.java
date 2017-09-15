package algorithms.functional.interfaces.binary_operator;

@FunctionalInterface
public interface CharBinaryOperator {
    /**
     * Applies this operator to the given operands.
     *
     * @param left the first operand
     * @param right the second operand
     * @return the operator result
     */
    char applyAsChar(char left, char right);
}
