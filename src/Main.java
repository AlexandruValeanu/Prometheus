import static algorithms.number_theory.SieveOfEratosthenes.getPrimes;

public class Main {

    public static void main(String[] args) {
        for (int p: getPrimes(0, 20))
            System.out.println(p);
    }
}
