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
}
