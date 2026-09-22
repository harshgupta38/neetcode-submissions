class Twitter {
    private class Node {
        int time, tweetId;
        Node next;

        Node(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    private Map<Integer, Set<Integer>> following;
    private Map<Integer, Node> tweets;
    private int time;

    public Twitter() {
        this.following = new HashMap<>();
        this.tweets = new HashMap<>();
        this.time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Node node = new Node(time++, tweetId);
        node.next = tweets.get(userId);
        tweets.put(userId, node);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Node> maxheap = new PriorityQueue<>((a,b) -> b.time - a.time);
        if (tweets.containsKey(userId))
            maxheap.offer(tweets.get(userId));

        if (following.containsKey(userId)) {
            for (int next : following.get(userId)) {
                if (tweets.containsKey(next))
                    maxheap.offer(tweets.get(next));
                if (maxheap.size() == 10)
                    break;
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!maxheap.isEmpty() && list.size() < 10) {
            Node t = maxheap.poll();
            list.add(t.tweetId);
            if (t.next != null)
                maxheap.offer(t.next);
        }
        return list;
    }

    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, o -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        following.get(followerId).remove(followeeId);
    }
}
