package algorithms.number_theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static algorithms.number_theory.Primality.isPrime;

public class SieveOfEratosthenes {
    private SieveOfEratosthenes(){}

    public static boolean[] computeSieve(int n){ // n - inclusive
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
        if (n <= 1)
            return new int[0];

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

    public static int countPrimes(int n){
        return getPrimes(n).length;
    }

    public static int[] getPrimes(int a, int b){
        if (a < 2)
            a = 2;

        if (a > b)
            return new int[0];

        boolean[] marked = new boolean[b - a + 1];
        int[] smallPrimes = getPrimes((int) Math.sqrt(b));

        for (int p: smallPrimes){
            int x = Math.max(a / p, 2);

            for (int k = p * x; k <= b; k += p)
                if (k >= a)
                    marked[k - a] = true;
        }

        int c = 0;
        for (int i = 0; i < b - a + 1; i++) {
            if (!marked[i])
                c++;
        }

        int[] segmentedPrimes = new int[c];
        c = 0;

        for (int i = 0; i < b - a + 1; i++) {
            if (!marked[i])
                segmentedPrimes[c++] = a + i;
        }

        return segmentedPrimes;
    }

    public static int countPrimes(int a, int b){
        return getPrimes(a, b).length;
    }

    public static long[] getPrimes(long a, long b){
        List<Long> list = new ArrayList<>();

        for (long p = a; p <= b; p++)
            if (isPrime(p))
                list.add(p);

        long[] primes = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            primes[i] = list.get(i);
        }

        return primes;
    }

    public static int countPrimes(long a, long b){
        return getPrimes(a, b).length;
    }
}
