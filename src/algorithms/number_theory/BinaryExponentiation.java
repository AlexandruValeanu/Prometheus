package algorithms.number_theory;

public class BinaryExponentiation {
    private BinaryExponentiation(){}

    public static int pow(int a, int p){
        int sign = 1;

        if (a < 0){
            a = -a;
            sign = -1;
        }

        int result = 1;

        while (p > 0){
            if ((p & 1) == 1)
                result *= a;

            a *= a;
            p >>= 1;
        }

        return sign * result;
    }

    public static int powExact(int a, int p){
        int sign = 1;

        if (a < 0){
            a = -a;
            sign = -1;
        }

        int result = 1;

        while (p > 0){
            if ((p & 1) == 1)
                result = Math.multiplyExact(result, a);

            a = Math.multiplyExact(a, a);
            p >>= 1;
        }

        return sign * result;
    }

    public static long pow(long a, int p){
        int sign = 1;

        if (a < 0){
            a = -a;
            sign = -1;
        }

        long result = 1;

        while (p > 0){
            if ((p & 1) == 1)
                result *= a;

            a *= a;
            p >>= 1;
        }

        return sign * result;
    }

    public static long powExact(long a, int p){
        int sign = 1;

        if (a < 0){
            a = -a;
            sign = -1;
        }

        long result = 1;

        while (p > 0){
            if ((p & 1) == 1)
                result = Math.multiplyExact(result, a);

            a = Math.multiplyExact(a, a);
            p >>= 1;
        }

        return sign * result;
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

    public static int powModExact(int a, int p, int mod){
        assert 0 <= a && a < mod;

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
                result = ModularArithmetic.russianPeasantMultiplication(result, a, mod);

            a = ModularArithmetic.russianPeasantMultiplication(a, a, mod);
            p >>= 1;
        }

        return result;
    }

    public static long powModExact(long a, long p, long mod){
        assert 0 <= a && a < mod;

        long result = 1;

        while (p > 0){
            if ((p & 1) == 1)
                result = ModularArithmetic.russianPeasantMultiplicationExact(result, a, mod);

            a = ModularArithmetic.russianPeasantMultiplicationExact(a, a, mod);
            p >>= 1;
        }

        return result;
    }
}
