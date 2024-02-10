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
    public ListNode rev(ListNode node){
        ListNode temp=node,prev=null;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode first=head,newHead=slow.next;
        ListNode second=rev(newHead);
        while(second!=null){
            if(first.val!=second.val){
                rev(newHead);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        rev(newHead);
        return true;
        
    }
}