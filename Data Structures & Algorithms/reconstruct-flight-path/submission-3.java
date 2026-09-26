class Solution {

    private Map<String, PriorityQueue<String>> graph;
    private LinkedList<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        this.graph = new HashMap<>();
        this.result = new LinkedList<>();

        for (List<String> ticket : tickets) 
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));

        dfs("JFK");
        return result;
    }

    private void dfs(String from) {
        PriorityQueue<String> destinations = graph.get(from);

        while (destinations != null && !destinations.isEmpty()) {
            String to = destinations.poll();
            dfs(to);
        }

        result.addFirst(from);
    }
}