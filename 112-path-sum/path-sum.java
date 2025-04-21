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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        Stack<TreeNode> path=new Stack<>();
        Stack<Integer> pathSum=new Stack<>();
        path.push(root);
        pathSum.push(root.val);

        while(!path.isEmpty()){
            TreeNode tempNode=path.pop();
            int totalSum=pathSum.pop();

            if(tempNode.left==null && tempNode.right==null && totalSum==targetSum){
                return true;
            }
            if(tempNode.right!=null){
                path.add(tempNode.right);
                pathSum.add(totalSum+ tempNode.right.val);
            }
             if(tempNode.left!=null){
                path.add(tempNode.left);
                pathSum.add(totalSum+ tempNode.left.val);
            }
        }
        return false;
    }
}