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
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // if(root== null)
        //     return new TreeNode(val);

        // if(root.val>val){
        //     root.left=insertIntoBST(root.left,  val);
        // }
        // else{
        //     root.right=insertIntoBST(root.right,val);
        // }
        // return root;
        if(root==null)
           return new TreeNode(val);

        TreeNode prevNode=null;
        TreeNode curr=root;
        while(curr!=null){
            prevNode=curr;
            if(curr.val>val){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        if(prevNode.val>val){
            prevNode.left=new TreeNode(val);
        }
        else{
            prevNode.right=new TreeNode(val);

        }
        return root;
    }
}