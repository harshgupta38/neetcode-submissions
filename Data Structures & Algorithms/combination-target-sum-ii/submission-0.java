class Solution {
    private List<List<Integer>> list;
    private int[] nums;
    private boolean[] used;
    private int target;

    private void backtrack(List<Integer> list, int i, int sum){
        if(sum==target){
            this.list.add(new ArrayList<>(list));
            return;
        }
        if(sum>target) return;

        for(;i<nums.length;i++){
            if(sum+nums[i]>target) return;
            if(i>0 && nums[i-1]==nums[i] && !used[i-1]) continue;
            list.add(nums[i]);
            used[i]=true;
            backtrack(list, i+1, sum+nums[i]);
            list.removeLast();
            used[i]=false;
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        this.list=new ArrayList<>();
        this.nums=nums;
        this.used=new boolean[nums.length];
        this.target=target;

        backtrack(new ArrayList<>(), 0, 0);
        return this.list;
    }
}
