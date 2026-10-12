class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);

        int c=0, n=heights.length;
        for(int i=0;i<n;i++)
        if(heights[i]!=expected[i])
            ++c;
        return c;
    }
}