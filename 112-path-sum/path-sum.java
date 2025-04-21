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
        Stack<TreeNode> sum=new Stack<>();
        Stack<Integer> pathSum=new Stack<>();
        sum.push(root);
        pathSum.push(root.val);

        while(!sum.isEmpty()){
            TreeNode tempNode=sum.pop();
            int totalSum=pathSum.pop();

            if(tempNode.left==null && tempNode.right==null && totalSum==targetSum){
                return true;
            }
            if(tempNode.right!=null){
                sum.add(tempNode.right);
                pathSum.add(totalSum+ tempNode.right.val);
            }
             if(tempNode.left!=null){
                sum.add(tempNode.left);
                pathSum.add(totalSum+ tempNode.left.val);
            }
        }
        return false;
    }
}