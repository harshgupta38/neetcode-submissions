class Solution {
    private List<List<Integer>> list;
    private int[] nums;
    private int target;

    private void backtrack(List<Integer> list, int i, int sum){
        if(sum==target){
            this.list.add(new ArrayList<>(list));
            return;
        }
        if(sum>target) return;

        for(;i<nums.length;i++){
            if(sum+nums[i]>target) return;
            list.add(nums[i]);
            backtrack(list, i, sum+nums[i]);
            list.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        this.nums=nums;
        this.list=new ArrayList<>();
        this.target=target;

        backtrack(new ArrayList<>(), 0, 0);
        return this.list;
    }
}
