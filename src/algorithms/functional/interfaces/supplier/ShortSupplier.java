package algorithms.functional.interfaces.supplier;

import java.util.function.Supplier;

/**
 * Represents a supplier of {@code int}-valued results.  This is the
 * {@code int}-producing primitive specialization of {@link Supplier}.
 *
 * <p>There is no requirement that a distinct result be returned each
 * time the supplier is invoked.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #getAsShort()}.
 *
 */
@FunctionalInterface
public interface ShortSupplier {

    /**
     * Gets a result.
     *
     * @return a result
     */
    short getAsShort();
}
