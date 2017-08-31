package algorithms.number_theory;

public class NumberOfDivisors {
    private NumberOfDivisors(){}

    public static int naiveCountDivisors(int n){
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
}
