package data_structures.range_structures;

import java.util.function.IntBinaryOperator;

class SegmentTree {
    private static class Node{
        public int key;

        Node(int key) {
            this.key = key;
        }

        static Node merge(Node L, Node R, IntBinaryOperator binaryOperator){
            return new Node(binaryOperator.applyAsInt(L.key, R.key));
        }

        static void merge(Node T, Node L, Node R, IntBinaryOperator binaryOperator){
            T.key = binaryOperator.applyAsInt(L.key, R.key);
        }
    }

    private Node[] tree;
    private final int N;

    private final IntBinaryOperator binaryOperator;

    public SegmentTree(int N, IntBinaryOperator binaryOperator){
        tree = new Node[4 * N];
        this.N = N;
        this.binaryOperator = binaryOperator;
    }

    public SegmentTree(int[] array, IntBinaryOperator binaryOperator){
        this(array.length, binaryOperator);
        build(1, 0, N - 1, array);
    }

    public void update(int position, int newKey){
        assert 0 <= position && position < N;
        update(1, 0, N - 1, position, newKey);
    }

    public int query(int x, int y){
        assert 0 <= x && x <= y && y < N;
        return query(1, 0, N - 1, x, y);
    }

    private void build(int node, int l, int r, int[] array){
        if (l == r)
            tree[node] = new Node(array[l]);
        else{
            int m = (l + r) / 2;

            build(2 * node, l, m, array);
            build(2 * node + 1, m + 1, r, array);

            tree[node] = Node.merge(tree[2 * node], tree[2 * node + 1], binaryOperator);
        }
    }

    private void update(int node, int l, int r, int position, int key){
        if (l == r)
            tree[node].key = key;
        else{
            int m = (l + r) / 2;

            if (position <= m)
                update(2 * node, l, m, position, key);
            else
                update(2 * node + 1, m + 1, r, position, key);

            Node.merge(tree[node], tree[2 * node], tree[2 * node + 1], binaryOperator);
        }
    }

    private int query(int node, int l, int r, int st_q, int dr_q){
        if (st_q <= l && r <= dr_q)
            return tree[node].key;
        else{
            int m = (l + r) / 2;

            if (st_q <= m && m < dr_q){
                int left = query(2 * node, l, m, st_q, dr_q);
                int right = query(2 * node + 1, m + 1, r, st_q, dr_q);

                return binaryOperator.applyAsInt(left, right);
            }
            else if (st_q <= m)
                return query(2 * node, l, m, st_q, dr_q);
            else
                return query(2 * node + 1, m + 1, r, st_q, dr_q);
        }
    }
}
