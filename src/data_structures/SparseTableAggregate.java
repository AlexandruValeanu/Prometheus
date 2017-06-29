package data_structures;

import data_structures.exceptions.NotBuiltSparseTableException;

import java.util.function.IntBinaryOperator;

public class SparseTableAggregate {
    private IntBinaryOperator binaryOperator;
    private int N;
    private int[][] rmq;
    private int[] log2;

    public SparseTableAggregate(int N, IntBinaryOperator operator){
        this.binaryOperator = operator;
        this.N = N;
        this.rmq = new int[32 - Integer.numberOfLeadingZeros(N)][N];
    }

    public SparseTableAggregate(int[] values, IntBinaryOperator operator){
        this.binaryOperator = operator;
        this.N = values.length;
        this.rmq = new int[32 - Integer.numberOfLeadingZeros(N)][N];

        for (int i = 0; i < N; i++) {
            set(i, values[i]);
        }
    }

    public void set(int index, int key){
        rmq[0][index] = key;
    }

    public void buildTable(){
        this.log2 = new int[N + 1];
        log2[1] = 0;

        for (int i = 2; i <= N; i++)
            log2[i] = log2[i >> 1] + 1;

        for (int i = 1; (1 << i) <= N; ++i)
            for (int j = 0; j + (1 << i) - 1 < N; ++j) {
                rmq[i][j] = binaryOperator.applyAsInt(rmq[i - 1][j], rmq[i - 1][j + (1 << (i - 1))]);
            }
    }

    public int query(int x, int y){
        if (log2 == null)
            throw new NotBuiltSparseTableException();

        int k = log2[y - x + 1];
        return binaryOperator.applyAsInt(rmq[k][x], rmq[k][y - (1 << k) + 1]);
    }
}
