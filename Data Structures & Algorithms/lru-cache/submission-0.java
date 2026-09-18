class LRUCache {
    private class Node {
        int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> map;
    // key -> node
    private int maxSize, size;
    private Node head, tail;
    // head = recently used, new nodes added here
    // tail = least used

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.maxSize = capacity;
        this.size = 0;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (size == 0 || !map.containsKey(key))
            return -1;

        Node node = map.get(key);
        remove(node);
        add(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (size == 0 || !map.containsKey(key)) {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);

            if (size > maxSize) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
        } else {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            add(node);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        --size;
    }

    private void add(Node node) {
        Node second = head.next;

        head.next = node;
        node.next = second;
        second.prev = node;
        node.prev = head;

        ++size;
    }
}
