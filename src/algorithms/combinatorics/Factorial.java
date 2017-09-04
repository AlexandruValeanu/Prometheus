package algorithms.combinatorics;

import algorithms.number_theory.EulerTotientFunction;
import algorithms.number_theory.ModularArithmetic;
import algorithms.number_theory.ModularInverse;

import java.math.BigInteger;

public class Factorial {
    private Factorial(){}

    public static long computeFactorial(int n){
        long sol = 1;

        for (int i = 2; i <= n; i++) {
            sol *= i;
        }

        return sol;
    }

    public static BigInteger computeFactorialBig(int n){
        BigInteger sol = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            sol = sol.multiply(BigInteger.valueOf(i));
        }

        return sol;
    }

    public static long computeFactorialMod(int n, int modulo){
        int sol = 1;

        for (int i = 2; i <= n; i++) {
            sol = (int) (((long) sol * i) % modulo);
        }

        return sol;
    }

    public static long[] computeFactorialArray(int n){
        assert n >= 1;

        long[] fact = new long[n + 1];
        fact[0] = fact[1] = 1;

        for (int i = 2; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        return fact;
    }

    public static BigInteger[] computeFactorialArrayBig(int n){
        assert n >= 1;

        BigInteger[] fact = new BigInteger[n + 1];
        fact[0] = fact[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            fact[i] = fact[i - 1].multiply(BigInteger.valueOf(i));
        }

        return fact;
    }

    public static int[] computeFactorialModArray(int n, int modulo){
        assert n >= 1;

        int[] fact = new int[n + 1];
        fact[0] = fact[1] = 1;

        for (int i = 2; i <= n; i++) {
            fact[i] = (int) (((long) fact[i - 1] * i) % modulo);
        }

        return fact;
    }

    public static int[] computeInverseFactorialModArray(int n, int modulo){
        assert n >= 1;
        int phi = EulerTotientFunction.computePhi(modulo);

        int[] invFact = new int[n + 1];
        invFact[0] = invFact[1] = 1;

        int factorial = 1;

        for (int i = 2; i <= n; i++) {
            factorial = ModularArithmetic.multiplyMod(factorial, i, modulo);
            invFact[i] = ModularInverse.computeModInverse(factorial, modulo, phi);
        }

        return invFact;
    }
}
