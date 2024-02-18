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
    public ListNode reverseBetween(ListNode head, int left, int right) {
         if (head == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preLeft = dummy;
        ListNode currNode= head;

        for(int i = 0; i<left-1; i++) {
            preLeft = preLeft.next;
            currNode=currNode.next;
        }

        ListNode markerNode=currNode;

        ListNode preNode=null;
        for(int i=0;i<=right-left;i++){
            ListNode front=currNode.next;
            currNode.next=preNode;
            preNode=currNode;
            currNode=front;
        }

        preLeft.next=preNode;
        markerNode.next=currNode;
        
        return dummy.next;
        
    }
}