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
    public ListNode swapPairs(ListNode head) {
        ListNode dnode=new ListNode(-1);
        dnode.next=head;
        ListNode temp=dnode;
      
        if(head==null || head.next==null){
            return head;
        }
        
        while(temp.next!=null && temp.next.next!=null){
            ListNode p1=temp.next;
            ListNode p2=temp.next.next;

            p1.next=p2.next;
            p2.next=p1;

            temp.next=p2;
            temp=p1;

        }
        return dnode.next;
        
    }
}