class MyHashMap {
    private class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private ListNode[] buckets;

    public MyHashMap() {
        this.buckets = new ListNode[1000];
    }

    public void put(int key, int val) {
        int index = key % 1000;

        ListNode curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                curr.val = val; // update existing key
                return;
            }
            curr = curr.next;
        }

        // Key doesn't exist, so insert new node
        ListNode newNode = new ListNode(key, val);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public int get(int key) {
        int index = key % 1000;
        if (buckets[index] == null)
            return -1;

        ListNode curr = buckets[index];
        while (curr != null) {
            if (curr.key == key)
                return curr.val;
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % 1000;
        if (buckets[index] == null)
            return;

        ListNode curr = buckets[index];
        if (curr.key == key) {
            buckets[index] = curr.next;
            return;
        }

        ListNode prev = curr;
        curr = curr.next;
        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */