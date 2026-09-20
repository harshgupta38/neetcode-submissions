class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones) maxHeap.offer(stone);

        while(maxHeap.size()>1){
            int heavy=maxHeap.poll();
            int light=maxHeap.poll();

            if(heavy>light)
                maxHeap.offer(heavy-light);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
