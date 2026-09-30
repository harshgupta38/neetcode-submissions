class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        int[] ans = new int[n];
        int top = -1;

        for (String o : operations) {
            char ch = o.charAt(0);
            if (ch == '+' && o.length() == 1) {
                int num1 = ans[top - 1];
                int num2 = ans[top];
                ans[++top] = num1 + num2;
            } else if (ch == 'C') {
                --top;
            } else if (ch == 'D') {
                ans[top + 1] = ans[top++] * 2;
            } else {
                ans[++top] = Integer.parseInt(o);
            }
        }

        int sum = 0;
        for (int i = 0; i <= top; i++) sum += ans[i];
        return sum;
    }
}