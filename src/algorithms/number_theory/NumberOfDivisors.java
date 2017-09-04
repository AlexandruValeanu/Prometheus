package algorithms.number_theory;

// http://codeforces.com/blog/entry/22317

import static algorithms.number_theory.Primality.isPrime;

public class NumberOfDivisors {
    private NumberOfDivisors(){}

    public static int countDivisorsNaive(int n){
        int sol = 1;

        for (int i = 2; i * i <= n; i++) {
            int e = 0;

            while (n % i == 0){
                e++;
                n /= i;
            }

            sol *= (e + 1);
        }

        return sol;
    }

    public static double nthRoot(double number, double r) {
        return Math.pow(Math.E, Math.log(number)/r);
    }

    public static boolean squareOfPrime(long n){
        int p = (int) Math.sqrt(n);
        return (long) p * p == n && isPrime(p);
    }

    // O(N^1/3)
    public static int countDivisors(long n){
        int[] primes = SieveOfEratosthenes.getPrimes((int) Math.ceil(nthRoot(n, 3)));

        int answer = 1;

        for (int p: primes){
            if ((long) p * p * p > n)
                break;

            int e = 1;
            while (n % p == 0){
                n /= p;
                e++;
            }

            answer *= e;
        }

        if (isPrime(n))
            answer *= 2;
        else if (squareOfPrime(n))
            answer *= 3;
        else if (n != 1)
            answer *= 4;

        return answer;
    }
}
