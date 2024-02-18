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

class Pair{

    int value;
    ListNode node;

    public Pair(int value , ListNode node){
        this.value = value;
        this.node = node;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.value - y.value);

        for(int i =0; i<lists.length; i++){
            if(lists[i]!=null)pq.add(new Pair(lists[i].val , lists[i]));
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            Pair list = pq.peek();
            pq.remove();
            if(list.node.next!=null)pq.add(new Pair(list.node.next.val , list.node.next));
            temp.next = list.node;
            temp = temp.next;
        }
        temp.next = null;
        return dummy.next;

        
    }
}