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
    public ListNode reverseList(ListNode head) {
        // Stack<Integer> st=new Stack<Integer>();
        // ListNode temp=head;
        // while(temp!=null){
        //     st.push(temp.val);
        //     temp=temp.next;
        // }
        // temp=head;
        // while(temp!=null){
        //     temp.val=st.pop();
        //     temp=temp.next;
        // }
        ListNode prev=null;
        ListNode temp=head;
        while(temp !=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;


        
    }
}