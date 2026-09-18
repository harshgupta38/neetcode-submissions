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
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length-1);
    }

    private ListNode divide(ListNode[] lists, int left, int right){
        if(left>right) return null;
        if(left==right) return lists[left];

        int mid=(left+right)/2;
        ListNode l=divide(lists, left, mid);
        ListNode r=divide(lists, mid+1, right);
        return merge(l,r);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                l1=l1.next;
            } else {
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        if(l1!=null) tail.next=l1;
        if(l2!=null) tail.next=l2;
        return dummy.next;
    }
}
