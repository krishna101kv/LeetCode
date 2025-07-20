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
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return true;
        }
        int v=root.val;
        List<Integer> ans=new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currNode=queue.remove();
            if(currNode.left!=null){
                if(currNode.left.val!=v){
                    return false;
                }
                queue.add(currNode.left);
            }
            if(currNode.right!=null){
                if(currNode.right.val!=v){
                    return false;
                }
                queue.add(currNode.right);
            }
        }
        return true;
    }
}