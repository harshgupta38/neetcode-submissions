class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int curr : asteroids) {
            
            while (!stack.isEmpty() && curr < 0 && stack.peek() > 0) {
                int right = stack.pop();
                if (right > -curr)
                    curr = right;
                else if (right == -curr)
                    curr = 0;
            }

            if (curr != 0)
                stack.push(curr);
        }
        int[] ans = new int[stack.size()];
        int i = ans.length - 1;
        while (!stack.isEmpty()) ans[i--] = stack.pop();
        return ans;
    }
}