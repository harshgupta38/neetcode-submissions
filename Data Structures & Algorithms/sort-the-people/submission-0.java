class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] < heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;

                    String t = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = t;
                }
            }
        }
        return names;
    }
}