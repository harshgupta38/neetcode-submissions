class Solution {
    private int[] parent;

    private int root(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = root(parent[x]);
    }

    private boolean union(int x, int y) {
        int rx = root(x);
        int ry = root(y);
        if (rx == ry)
            return false;
        parent[rx] = ry;
        return true;
    }

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int count = n;
        for (int[] edge : edges)
            if (union(edge[0], edge[1]))
                --count;
        return count;
    }
}
