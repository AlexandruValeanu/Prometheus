package algorithms.number_theory;

public class EulerTotientFunction {
    private EulerTotientFunction(){}

    public static int computePhi(int n){
        long phi = n;

        for (int i = 2; i * i <= n; i++)
            if (n % i == 0){
                while (n % i == 0){
                    n /= i;
                }

                phi = (phi / i) * (i - 1);
            }

        if (n != 1)
            phi = (phi / n) * (n - 1);

        return (int) phi;
    }

    public static long computePhi(long n){
        long phi = n;

        for (long i = 2; i * i <= n; i++)
            if (n % i == 0){
                while (n % i == 0){
                    n /= i;
                }

                phi = (phi / i) * (i - 1);
            }

        if (n != 1)
            phi = (phi / n) * (n - 1);

        return phi;
    }
}
