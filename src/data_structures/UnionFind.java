package data_structures;

public class UnionFind {
    private final int[] father;
    private final int[] rank;
    private final int[] size;
    private final int N;
    private int numberOfComponents;

    public UnionFind(int N){
        this.N = N;
        rank = new int[N];
        father = new int[N];
        size = new int[N];
        numberOfComponents = 0;

        for (int i = 0; i < N; i++)
            makeSet(i);
    }

    public void makeSet(int node){
        father[node] = node;
        rank[node] = 1;
        size[node] = 1;
        numberOfComponents++;
    }

    public int findRoot(int node){
        if (father[node] == node)
            return node;
        else
            return father[node] = findRoot(father[node]);
    }

    public void union(int x, int y){
        x = findRoot(x);
        y = findRoot(y);

        if (x != y){
            numberOfComponents--;

            if (rank[x] < rank[y]) {
                father[x] = y;
                size[y] += size[x];
            }
            else {
                father[y] = x;
                size[x] += size[y];

                if (rank[x] == rank[y])
                    rank[x]++;
            }
        }
    }

    public boolean connected(int x, int y){
        return findRoot(x) == findRoot(y);
    }

    public int sizeComponent(int node){
        return size[findRoot(node)];
    }

    public int getNumberOfComponents(){
        return numberOfComponents;
    }

    public int size(){
        return N;
    }
}
