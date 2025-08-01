/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        if(root==null){
            return root;
        }
        while(!queue.isEmpty()){
            int currSize=queue.size();
            ArrayList<Node> currLevel=new ArrayList<>();
            Node prevNode=null;
            for(int i=0;i<currSize;i++){
                Node currNode=queue.remove();
                if(i!=0){
                    prevNode.next=currNode;
                }
                prevNode=currNode;
                if(currNode.left!=null){
                    queue.add(currNode.left);
                }
                if(currNode.right!=null){
                    queue.add(currNode.right);
                }
            }
        }
        return root;
    }
}