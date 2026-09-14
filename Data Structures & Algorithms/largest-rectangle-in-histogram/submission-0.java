class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int currentHeight = i == n ? 0 : heights[i];
            while (!indexStack.isEmpty() && currentHeight <= heights[indexStack.peek()]) {
                int height = heights[indexStack.pop()];
                int width = indexStack.isEmpty() ? i : i - indexStack.peek() - 1;
                max = Math.max(max, height * width);
            }
            indexStack.push(i);
        }
        return max;
    }
}
