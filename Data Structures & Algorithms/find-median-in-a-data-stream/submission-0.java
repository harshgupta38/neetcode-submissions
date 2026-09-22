class MedianFinder {
    private PriorityQueue<Integer> min, max;

    public MedianFinder() {
        this.min = new PriorityQueue<>();
        this.max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        min.add(num);
        max.add(min.poll());
        if (max.size() > min.size())
            min.add(max.poll());
    }

    public double findMedian() {
        if (min.size() > max.size())
            return min.peek();
        return (double) (min.peek() + max.peek()) / 2;
    }
}
