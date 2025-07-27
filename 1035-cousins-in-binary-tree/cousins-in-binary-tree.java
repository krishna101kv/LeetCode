/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair{
    TreeNode node;
    TreeNode parent;
    Pair(TreeNode node,TreeNode parent){
        this.node=node;
        this.parent=parent;
    }
 }
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> queue=new LinkedList<>();
        TreeNode parentOfX=null;
        TreeNode parentOfY=null;
        queue.add(new Pair(root,new TreeNode(-1)));
        while(!queue.isEmpty()){
            int currSize=queue.size();
            for(int i=0;i<currSize;i++){
                Pair currPair=queue.remove();
                TreeNode currNode=currPair.node;
                TreeNode currParent=currPair.parent;
                if(currNode.val==x){
                    parentOfX=currParent;
                }
                if(currNode.val==y){
                    parentOfY=currParent;
                }
                if(currNode.left!=null){
                    queue.add(new Pair(currNode.left, currNode));
                }
                if(currNode.right!=null){
                    queue.add(new Pair(currNode.right, currNode));
                }
            }
            if(parentOfX!=null && parentOfY!=null){
                return parentOfX.val!=parentOfY.val;
            }
            if(parentOfX!=null || parentOfY!=null){
                return false;
            }
        }
        return false;
    }
}