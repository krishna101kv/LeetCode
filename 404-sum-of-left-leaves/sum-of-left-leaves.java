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
     boolean left;
     Pair(TreeNode node,boolean left){
         this.node=node;
         this.left=left;
     }
 }
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<Pair> queue=new LinkedList<>();
        int total=0;

        queue.add(new Pair(root,false));
        while(!queue.isEmpty()){
            Pair currPair=queue.remove();
            TreeNode currNode=currPair.node;
            boolean isLeft=currPair.left;
            if(currNode.left==null && currNode.right==null && isLeft){
                total+=currNode.val;
            }
            if(currNode.left!=null){
                queue.add(new Pair(currNode.left,true));
            }
            if(currNode.right!=null){
                queue.add(new Pair(currNode.right,false));
            }
        }
        return total;
    }
}

    // public int sumOfLeftLeaves(TreeNode root) {
    //     return sumOfLeft(root,false);
    // }
    // public int sumOfLeft(TreeNode root,Boolean onLeft){
    //     if(root==null){
    //         return 0;
    //     }
    //     if(root.left==null && root.right==null){
    //         return (onLeft?root.val:0);
    //     }
    //     int l=sumOfLeft(root.left,true);
    //     int r=sumOfLeft(root.right,false);
    //     return l+r;
    // }