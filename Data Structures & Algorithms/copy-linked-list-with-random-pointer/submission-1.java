/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        curr = head;
        while (curr != null) {
            curr.next.random = curr.random == null ? null : curr.random.next;
            curr = curr.next.next;
        }

        curr = head;
        Node newHead = new Node(0);
        Node tail = newHead;
        while (curr != null) {
            Node next = curr.next;
            tail.next = next;
            tail = tail.next;
            curr.next = next.next;

            curr = curr.next;
        }
        return newHead.next;
    }
}
