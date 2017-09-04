import algorithms.functional.Functional;

public class Main {

    public static void main(String[] args) {
        Integer[] xs = new Integer[4];

        for (int i = 0; i < xs.length; i++) {
            xs[i] = i + 1;
        }

        System.out.println(Functional.foldl((x, y) -> x + y, 0, xs));
    }
}
