class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int max;

    public KthLargest(int k, int[] nums) {
        this.minHeap=new PriorityQueue<>();
        this.max=k;

        for(int num:nums) add(num);
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size()>max)
        minHeap.poll();
        return minHeap.peek();
    }
}
