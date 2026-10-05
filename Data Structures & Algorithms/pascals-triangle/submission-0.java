class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        if (n == 1)
            return list;
        list.add(Arrays.asList(1, 1));
        if (n == 2)
            return list;

        for (int i = 2; i < n; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    l.add(1);
                else {
                    List<Integer> prev = list.get(i - 1);
                    l.add(prev.get(j) + prev.get(j - 1));
                }
            }
            list.add(l);
        }
        return list;
    }
}