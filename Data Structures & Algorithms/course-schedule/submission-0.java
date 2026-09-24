class Solution {
    public boolean canFinish(int n, int[][] data) {
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] d : data) {
            int first = d[1], second = d[0];
            map.computeIfAbsent(first, o -> new ArrayList<>()).add(second);
            ++inDegree[second];
        }

        Queue<Integer> queue = new LinkedList<>();
        int done = 0;
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            ++done;
            if (map.containsKey(now)) {
                for (int next : map.get(now)) {
                    --inDegree[next];
                    if (inDegree[next] == 0)
                        queue.offer(next);
                }
            }
        }
        return done == n;
    }
}
