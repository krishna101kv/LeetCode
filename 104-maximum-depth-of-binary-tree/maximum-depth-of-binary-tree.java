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
    public int maxDepth(TreeNode root) {
        return height(root);
        
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftNode=height(root.left);
        int rightNode=height(root.right);
        return 1+Math.max(leftNode,rightNode);
    }
}