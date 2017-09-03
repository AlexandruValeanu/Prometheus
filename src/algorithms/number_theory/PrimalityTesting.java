package algorithms.number_theory;

public class PrimalityTesting {
    private PrimalityTesting(){}

    public static boolean isPrimeNaive(int n){
        if (n == 1)
            return false;

        for (int i = 2, s = (int) Math.sqrt(n); i <= s; i++) {
            if (n % i == 0)
                return false;
        }
        
        return true;
    }

    public static boolean isPrimeNaiveOpt(int n){
        if ((n > 2 && n % 2 == 0) || n == 1)
            return false;

        for (int i = 3, s = (int) Math.sqrt(n); i <= s; i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    private static boolean slowWitness(long a, long d, long n, int s){
        if (BinaryExponentiation.powMod(a, d, n) == 1)
            return false; // possibly prime

        for (int i = 0; i < s; i++) {
            if (BinaryExponentiation.powMod(a, (1L << i) * d, n) == n - 1)
                return false; // possibly prime
        }

        return true; // composite
    }

    private static boolean fastWitness(long a, long d, long n, int s){
        long x = BinaryExponentiation.powMod(a, d, n);

        if (x == 1 || x == n - 1)
            return false; // possibly prime

        for (int i = 0; i < s - 1; i++) {
            x = BinaryExponentiation.powMod(x, 2, n);

            if (x == 1)
                return true; // composite

            if (x == n - 1)
                return false; // possibly prime
        }

        return true; // composite
    }

    private static int[] basesInt = {2, 7, 61};
    private static int[] basesLong = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};

    public static boolean millerRabinPrimalityTest(long n){
        int[] bases;

        if (n <= Integer.MAX_VALUE)
            bases = basesInt;
        else
            bases = basesLong;

        if (n < 2)
            return false;

        if (n == 2 || n == 3)
            return true;

        if (n % 2 == 0)
            return false;

        int s = 0;
        long d = n - 1;

        while (true){
            long quotient = d / 2;
            long remainder = d % 2;

            if (remainder == 1)
                break;

            s += 1;
            d = quotient;
        }

        for (int a: bases){
            if (a != n && fastWitness(a, d, n, s)) // do not use a is a == n
                return false; // definitely composite
        }

        return true; // is prime
    }
    
    public static boolean isPrime(long n){
        return millerRabinPrimalityTest(n);
    }
}
