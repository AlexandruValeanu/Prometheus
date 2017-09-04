package algorithms.number_theory;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorization {
    private PrimeFactorization(){}

    private final static BigInteger TWO  = new BigInteger("2");
    private final static SecureRandom random = new SecureRandom();

    public static BigInteger getFactor(BigInteger N) {
        BigInteger c  = new BigInteger(N.bitLength(), random);
        BigInteger x  = new BigInteger(N.bitLength(), random);

        while (c.equals(BigInteger.ZERO)){
            c = new BigInteger(N.bitLength(), random);
        }

        while (x.equals(BigInteger.ZERO)){
            x = new BigInteger(N.bitLength(), random);
        }

        BigInteger y = x;
        BigInteger divisor;

        // check divisibility by 2
        if (N.mod(TWO).compareTo(BigInteger.ZERO) == 0)
            return TWO;

        do {
            x  =  x.multiply(x).add(c).mod(N);
            y = y.multiply(y).add(c).mod(N);
            y = y.multiply(y).add(c).mod(N);
            divisor = x.subtract(y).gcd(N);
        } while((divisor.compareTo(BigInteger.ONE)) == 0);

        return divisor;
    }

    private static long f(long x, long c, long N){
        return ModularArithmetic.addMod(ModularArithmetic.russianPeasantMultiplication(x, x, N), c, N);
    }

    public static long getFactor(long N) {
        long c  = random.nextLong() % N;
        long x  = random.nextLong() % N;

        while (c == 0){
            c = random.nextLong() % N;
        }

        while (x == 0){
            x = random.nextLong() % N;
        }

        long y = x;
        long divisor;

        // check divisibility by 2
        if (N % 2 == 0)
            return 2;

        do {
            x  = f(x, c, N);
            y  = f(y, c, N);
            y  = f(y, c, N);
            divisor = GreatestCommonDivisor.gcd(x - y, N);
        } while(divisor == 1);

        return divisor;
    }

    private static void factor(BigInteger N, List<BigInteger> factors) {
        if (N.compareTo(BigInteger.ONE) == 0)
            return;

        if (N.isProbablePrime(20)) {
            factors.add(N);
            return;
        }

        BigInteger divisor = getFactor(N);

        factor(divisor, factors);
        factor(N.divide(divisor), factors);
    }

    private static void factor(long N, List<Long> factors) {
        if (N == 1)
            return;

        if (Primality.isPrime(N)) {
            factors.add(N);
            return;
        }

        long divisor = getFactor(N);

        factor(divisor, factors);
        factor(N / divisor, factors);
    }

    public static BigInteger[] computePrimeFactorization(BigInteger N){
        N = N.abs();

        List<BigInteger> facts = new ArrayList<>();
        factor(N, facts);

        BigInteger[] factors = new BigInteger[facts.size()];
        for (int i = 0; i < facts.size(); i++) {
            factors[i] = facts.get(i);
        }

        Arrays.sort(factors);
        return factors;
    }

    public static long[] computePrimeFactorization(long N){
        N = Math.abs(N);

        List<Long> facts = new ArrayList<>();
        factor(N, facts);

        long[] factors = new long[facts.size()];
        for (int i = 0; i < facts.size(); i++) {
            factors[i] = facts.get(i);
        }

        Arrays.sort(factors);
        return factors;
    }
}
