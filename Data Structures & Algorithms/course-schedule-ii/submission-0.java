class Solution {
    public int[] findOrder(int n, int[][] data) {
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] d : data) {
            int first = d[1], second = d[0];
            map.computeIfAbsent(first, o -> new ArrayList<>()).add(second);
            ++inDegree[second];
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            list.add(now);
            if (map.containsKey(now)) {
                for (int next : map.get(now)) {
                    --inDegree[next];
                    if (inDegree[next] == 0)
                        queue.offer(next);
                }
            }
        }

        if (list.size() != n)
            return new int[0];

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = list.get(i);

        return ans;
    }
}
