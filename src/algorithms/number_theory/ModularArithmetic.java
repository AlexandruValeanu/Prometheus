package algorithms.number_theory;

import java.math.BigInteger;

public class ModularArithmetic {
    private ModularArithmetic(){}

    public static int addMod(int a, int b, int mod){
        int r = a + b;

        if (r >= mod)
            r -= mod;

        return r;
    }

    public static int addModExact(int a, int b, int mod){
        assert 0 <= a && a < mod;
        assert 0 <= b && b < mod;

        int r = Math.addExact(a, b);

        if (r >= mod)
            r -= mod;

        return r;
    }

    public static long addMod(long a, long b, long mod){
        long r = a + b;

        if (r >= mod)
            r -= mod;

        return r;
    }

    public static long addModExact(long a, long b, long mod){
        assert 0 <= a && a < mod;
        assert 0 <= b && b < mod;

        long r = Math.addExact(a, b);

        if (r >= mod)
            r -= mod;

        return r;
    }

    public static int subtractMod(int a, int b, int mod){
        int r = a - b;

        if (r < 0)
            r += mod;

        return r;
    }

    public static int subtractModExact(int a, int b, int mod){
        assert 0 <= a && a < mod;
        assert 0 <= b && b < mod;

        int r = Math.subtractExact(a, b);

        if (r < 0)
            r += mod;

        return r;
    }

    public static long subtractMod(long a, long b, long mod){
        long r = a - b;

        if (r < 0)
            r += mod;

        return r;
    }

    public static long subtractModExact(long a, long b, long mod){
        assert 0 <= a && a < mod;
        assert 0 <= b && b < mod;

        long r = Math.subtractExact(a, b);

        if (r < 0)
            r += mod;

        return r;
    }

    public static int multiplyMod(int a, int b, int mod){
        return (int) (((long) a * b) % mod);
    }

    public static int multiplyModExact(int a, int b, int mod){
        assert 0 <= a && a < mod;
        assert 0 <= b && b < mod;

        return (int) (Math.multiplyExact((long)a, (long)b) % mod);
    }

    public static long multiplyMod(long a, long b, long mod){
        return (a * b) % mod;
    }

    public static long multiplyModExact(long a, long b, long mod){
        assert 0 <= a && a < mod;
        assert 0 <= b && b < mod;

        return Math.multiplyExact(a, b) % mod;
    }

    public static int divideMod(int a, int b, int mod){
        return multiplyMod(a, ModularInverse.computeModInverse(b, mod), mod);
    }

    public static int divideMod(int a, int b, int mod, int phi){
        return multiplyMod(a, BinaryExponentiation.powMod(b, phi - 1, mod), mod);
    }

    public static int divideModPrime(int a, int b, int mod){
        return multiplyMod(a, ModularInverse.computeModInversePrime(b, mod), mod);
    }

    public static long MAX_LIMIT_RUSSIAN_PEASANT = (long) 1e15;

    public static long russianPeasantMultiplication(long a, long b, long mod){
        if (mod <= Integer.MAX_VALUE)
            return multiplyMod(a, b, mod);

        // todo: optimize for speed
        if (mod > MAX_LIMIT_RUSSIAN_PEASANT)
            return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();

        if (a > b){
            long t = a;
            a = b;
            b = t;
        }

        long result = 0;

        while (a > 0){
            if ((a & 1) == 1){
                result += b;

                if (result >= mod)
                    result -= mod;
            }

            a >>= 1;
            b <<= 1;

            if (b >= mod)
                b -= mod;
        }

        return result;
    }

    public static long russianPeasantMultiplicationExact(long a, long b, long mod){
        if (Math.multiplyExact(mod, 2L) <= Integer.MAX_VALUE)
            return multiplyModExact(a, b, mod);

        // todo: optimize
        if (mod > MAX_LIMIT_RUSSIAN_PEASANT)
            return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValueExact();

        long result = 0;

        while (a > 0){
            if ((a & 1) == 1){
                result = Math.addExact(result, b);

                if (result >= mod)
                    result -= mod;
            }

            a >>= 1;
            b = Math.multiplyExact(b, 2L);

            if (b >= mod)
                b -= mod;
        }

        return result;
    }
}
