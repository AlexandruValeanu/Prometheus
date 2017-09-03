package algorithms.number_theory;

import java.math.BigInteger;

public class BinaryExponentiation {
    private BinaryExponentiation(){}

    public static int pow(int a, int p){
        int result = 1;

        while (p > 0){
            if ((p & 1) == 1)
                result *= a;

            a *= a;
            p >>= 1;
        }

        return result;
    }

    public static long pow(long a, int p){
        long result = 1;

        while (p > 0){
            if ((p & 1) == 1)
                result *= a;

            a *= a;
            p >>= 1;
        }

        return result;
    }

    public static BigInteger pow(BigInteger a, int p){
        return a.pow(p);
    }

    public static int powMod(int a, int p, int mod){
        int result = 1;

        while (p > 0){
            if ((p & 1) == 1)
                result = (int) (((long) result * a) % mod);

            a = (int) (((long)a * a) % mod);
            p >>= 1;
        }

        return result;
    }

    public static long powMod(long a, long p, long mod){
        long result = 1;

        while (p > 0){
            if ((p & 1) == 1)
                result = (result * a) % mod;

            a = (a * a) % mod;
            p >>= 1;
        }

        return result;
    }

    public static long powModExact(long a, long p, long mod){
        long result = 1;

        while (p > 0){
            if ((p & 1) == 1)
                result = ModularArithmetic.russianPeasantMultiplicationExact(a, p, mod);

            a = ModularArithmetic.russianPeasantMultiplicationExact(a, a, mod);
            p >>= 1;
        }

        return result;
    }

    public static BigInteger powMod(BigInteger a, BigInteger p, BigInteger mod){
        return a.modPow(p, mod);
    }
}
