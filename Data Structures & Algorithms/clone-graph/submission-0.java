/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        this.map=new HashMap<>();
        return clone(node);
    }

    private Node clone(Node oldNode){
        if(oldNode==null) return null;
        if(map.containsKey(oldNode)) return map.get(oldNode);

        Node newNode = new Node(oldNode.val);
        map.put(oldNode, newNode);
        for(Node next:oldNode.neighbors)
        newNode.neighbors.add(clone(next));

        return newNode;
    }
}