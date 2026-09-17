/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode curr = head2;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null && prev != null) {
            tail.next = head;
            head = head.next;
            tail = tail.next;

            tail.next = prev;
            prev = prev.next;
            tail = tail.next;
        }

        if(head!=null) tail.next=head;

        head=dummy.next;
    }
}
