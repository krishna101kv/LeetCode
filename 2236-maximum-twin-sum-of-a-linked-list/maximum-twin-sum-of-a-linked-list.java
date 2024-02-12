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
        public ListNode rev(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        
        return prev;
    }
    public int pairSum(ListNode head) {
        int maxS=0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next= rev(slow.next);
        fast= head;
        while (slow.next != null) {
            maxS= Math.max(maxS, fast.val + slow.next.val);
            slow=slow.next;
            fast=fast.next;
        }
        return maxS;
    }
}
