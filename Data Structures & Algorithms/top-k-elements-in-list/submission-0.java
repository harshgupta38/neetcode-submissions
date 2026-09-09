class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int left=0;
        for(int right=1;right<=nums.length;right++){
            int curr=right==nums.length ? 1001 : nums[right];
            if(curr!=nums[right-1]){
                minHeap.offer(new int[]{nums[right-1],right-left});
                left=right;
                if(minHeap.size()>k)
                minHeap.poll();
            }
        }
        int[] ans=new int[minHeap.size()];
        int i=0;
        for(int[] num:minHeap)
        ans[i++]=num[0];
        return ans;
    }
}
