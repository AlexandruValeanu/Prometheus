package algorithms.number_theory;

import static algorithms.number_theory.Primality.isPrime;

public class ModularInverse {
    private ModularInverse(){}


    public static int computeModInversePrime(int a, int modPrime){
        return BinaryExponentiation.powMod(a, modPrime - 2, modPrime);
    }

    public static int computeModInversePrimeExact(int a, int modPrime){
        assert 0 <= a && a < modPrime;
        assert isPrime(modPrime);

        return BinaryExponentiation.powMod(a, modPrime - 2, modPrime);
    }

    public static long computeModInversePrime(long a, long modPrime){
        return BinaryExponentiation.powMod(a, modPrime - 2, modPrime);
    }

    public static long computeModInversePrimeExact(long a, long modPrime){
        assert 0 <= a && a < modPrime;
        assert isPrime(modPrime);

        return BinaryExponentiation.powMod(a, modPrime - 2, modPrime);
    }

    public static int computeModInverse(int a, int modulo){
        return BinaryExponentiation.powMod(a, EulerTotientFunction.computePhi(modulo) - 1, modulo);
    }

    public static int computeModInverseExact(int a, int modulo){
        assert GreatestCommonDivisor.gcd(a, modulo) == 1;
        return BinaryExponentiation.powMod(a, EulerTotientFunction.computePhi(modulo) - 1, modulo);
    }

    public static int computeModInverse(int a, int modulo, int phi){
        return BinaryExponentiation.powMod(a, phi - 1, modulo);
    }

    public static long computeModInverse(long a, long modulo, long phi){
        return BinaryExponentiation.powMod(a, phi - 1, modulo);
    }

    public static int computeModInverseExact(int a, int modulo, int phi){
        assert GreatestCommonDivisor.gcd(a, modulo) == 1;
        return BinaryExponentiation.powMod(a, phi - 1, modulo);
    }

    public static long computeModInverseExact(long a, long modulo, long phi){
        assert GreatestCommonDivisor.gcd(a, modulo) == 1;
        return BinaryExponentiation.powMod(a, phi - 1, modulo);
    }
}
