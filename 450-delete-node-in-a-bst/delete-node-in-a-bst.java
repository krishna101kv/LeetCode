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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
           return null;

        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else{
            if(root.left==null && root.right==null){
                root=null;
                return root;
            }
            if(root.left!=null && root.right==null){
                root=root.left;
                return root;
            }
            if(root.right!=null && root.left==null){
                root=root.right;
                return root;
            }
            TreeNode subsNode=findMinNode(root.right);
            root.val=subsNode.val;
            root.right=deleteNode(root.right,subsNode.val);
        }
        return root;
    }
    private TreeNode findMinNode(TreeNode current){
        while(current.left!=null){
            current=current.left;
        }
        return current;
    }
}