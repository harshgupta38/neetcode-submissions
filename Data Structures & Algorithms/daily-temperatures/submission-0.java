class Solution {
    public int[] dailyTemperatures(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                ans[stack.peek()]=i-stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
