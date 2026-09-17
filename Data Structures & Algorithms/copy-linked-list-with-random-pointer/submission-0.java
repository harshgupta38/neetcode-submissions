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
        Node newHead = head.next;
        Node curr2 = newHead;
        while (curr2 != null) {
            curr.next = curr.next.next;
            curr2.next = curr2.next == null ? null : curr2.next.next;

            curr = curr.next;
            curr2 = curr2.next;
        }
        return newHead;
    }
}
