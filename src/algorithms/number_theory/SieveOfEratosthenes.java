package algorithms.number_theory;

import algorithms.AlgorithmsOnRanges;

import java.util.Arrays;

public class SieveOfEratosthenes {
    private SieveOfEratosthenes(){}

    public static boolean[] computeSieve(int n){
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i <= n; i++) {
            if (sieve[i]){
                if ((long)i * i > n)
                    break;

                for (int j = i * i; j <= n; j += i)
                    sieve[j] = false;
            }
        }

        return sieve;
    }

    public static int[] getPrimes(int n){
        boolean[] sieve = computeSieve(n);
        int c = 0;

        for (boolean x: sieve)
            if (x)
                c++;

        int[] primes = new int[c];
        c = 0;

        for (int i = 0; i <= n; i++) {
            if (sieve[i])
                primes[c++] = i;
        }

        return primes;
    }
}
