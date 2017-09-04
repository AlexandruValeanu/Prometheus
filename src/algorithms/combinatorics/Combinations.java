package algorithms.combinatorics;

import algorithms.number_theory.ModularArithmetic;

import java.math.BigInteger;

public class Combinations {
    private Combinations(){}

    public static BigInteger nChooseKBig(int n, int k){
        if (k > n)
            return BigInteger.ZERO;

        BigInteger t1 = Factorial.computeFactorialBig(k);
        BigInteger t2 = Factorial.computeFactorialBig(n - k);

        return Factorial.computeFactorialBig(n).divide(t1.multiply(t2));
    }

    public static long nChoose2(int n){
        return (long)n * (n - 1) / 2;
    }

    public static long nChooseK(int n, int k){
        if (k > n)
            return 0;

        if (n == k || k == 0)
            return 1;

        long[][] comb = new long[n + 1][k + 1];
        comb[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            comb[i][0] = 1;

            if (i <= k)
                comb[i][i] = 1;

            for (int j = 1; j <= Math.min(i, k); j++) {
                comb[i][j] = comb[i - 1][j] + comb[i - 1][j - 1];
            }
        }

        return comb[n][k];
    }

    public static int nChooseK(int n, int k, int modulo){
        if (k > n)
            return 0;

        if (n == k || k == 0)
            return 1;

        int[][] comb = new int[n + 1][k + 1];
        comb[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            comb[i][0] = 1;

            if (i <= k)
                comb[i][i] = 1;

            for (int j = 1; j <= Math.min(i, k); j++) {
                comb[i][j] = ModularArithmetic.addMod(comb[i - 1][j], comb[i - 1][j - 1], modulo);
            }
        }

        return comb[n][k];
    }
}
