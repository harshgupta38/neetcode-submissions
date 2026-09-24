class Solution {
    private int[] parent;

    private int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    private boolean union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry)
            return false;
        parent[rx] = ry;
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges)
            if (!union(edge[0], edge[1]))
                return false;

        return true;
    }
}
