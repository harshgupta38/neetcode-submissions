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
            return true;
        parent[rx] = ry;
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int[] edge : edges)
            if (union(edge[0], edge[1]))
                return edge;
        return null;
    }
}
