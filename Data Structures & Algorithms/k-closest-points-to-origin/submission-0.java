class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int first = a[0] * a[0] + a[1] * a[1];
            int second = b[0] * b[0] + b[1] * b[1];
            return second - first;
        });

        for(int[] point:points){
        maxHeap.offer(point);
        if(maxHeap.size()>k)
        maxHeap.poll();
        }

        int[][] ans=new int[k][];
        int i=0;
        while(!maxHeap.isEmpty())
        ans[i++]=maxHeap.poll();

        return ans;
    }
}
