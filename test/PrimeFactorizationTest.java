import algorithms.number_theory.PrimeFactorization;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeFactorizationTest {
    @Test
    public void computePrimeFactorizationBigInteger() throws Exception {
    }

    @Test
    public void computePrimeFactorizationLong() throws Exception {
        for (long x: PrimeFactorization.computePrimeFactorization(Long.parseUnsignedLong("9223372036854775807")))
            System.out.printf("%d ", x);
    }
}