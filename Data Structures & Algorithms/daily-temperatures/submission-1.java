class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temp[i] > temp[stack.peek()])
                ans[stack.peek()] = i - stack.pop();
            stack.push(i);
        }
        return ans;
    }
}
