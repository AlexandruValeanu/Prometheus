package algorithms.number_theory;

public class ModularArithmetic {
    private ModularArithmetic(){}

    private static void checkBounds(int a, int b, int mod){
        assert 0 < mod;
        assert 0 <= a && a < mod;
        assert 0 <= b && b < mod;
    }

    private static void checkBounds(long a, long b, long mod){
        assert 0 < mod;
        assert 0 <= a && a < mod;
        assert 0 <= b && b < mod;
    }

    public static int addMod(int a, int b, int mod){
        int r = a + b;

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

    public static int addModExact(int a, int b, int mod){
        checkBounds(a, b, mod);
        int r = Math.addExact(a, b);

        if (r >= mod)
            r -= mod;

        return r;
    }

    public static long addModExact(long a, long b, long mod){
        checkBounds(a, b, mod);
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

    public static long subtractMod(long a, long b, long mod){
        long r = a - b;

        if (r < 0)
            r += mod;

        return r;
    }

    public static int subtractModExact(int a, int b, int mod){
        checkBounds(a, b, mod);
        int r = Math.subtractExact(a, b);

        if (r < 0)
            r += mod;

        return r;
    }

    public static long subtractModExact(long a, long b, long mod){
        checkBounds(a, b, mod);
        long r = Math.subtractExact(a, b);

        if (r < 0)
            r += mod;

        return r;
    }

    public static int multiplyMod(int a, int b, int mod){
        return (int) (((long) a * b) % mod);
    }

    public static long multiplyMod(long a, long b, long mod){
        return (a * b) % mod;
    }

    public static int multiplyModExact(int a, int b, int mod){
        checkBounds(a, b, mod);
        return (int) (Math.multiplyExact((long)a, (long)b) % mod);
    }

    public static int multiplyModExact(long a, long b, long mod){
        checkBounds(a, b, mod);
        return (int) (Math.multiplyExact(a, b) % mod);
    }

    public static int divideMod(int a, int b, int mod){
        // todo: implement
        return -1;
    }

    public static int divideModExact(int a, int b, int mod){
        // todo: implement
        return -1;
    }

    public static long divideMod(long a, long b, long mod){
        // todo: implement
        return -1;
    }

    public static long divideModExact(long a, long b, long mod){
        // todo: implement
        return -1;
    }

    public static long russianPeasantMultiplication(long a, long b, long mod){
        if (2 * mod <= Integer.MAX_VALUE)
            return multiplyMod(a, b, mod);

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
