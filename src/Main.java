import data_structures.SparseTableAggregate;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int N = 10000;
        Random random = new Random(0xDEAD);
        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            values[i] = random.nextInt();
        }

        SparseTableAggregate table = new SparseTableAggregate(values, Integer::max);
        table.buildTable();

        for (int i = 0; i < N; i++) {
            int maxim = values[i];

            for (int j = i; j < N; j++) {
                maxim = Math.max(maxim, values[j]);

                if (table.query(i, j) != maxim)
                    System.out.printf("%d %d %d %d\n", i, j, maxim, table.query(i, j));
            }
        }
    }
}
