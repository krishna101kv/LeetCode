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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        int leftAns=0;
        queue.add(root);
        while(!queue.isEmpty()){
            int currSize=queue.size();
            leftAns=queue.peek().val;
            while(currSize>0){
                TreeNode currNode=queue.remove();
                if(currNode.left!=null){
                queue.add(currNode.left);
                }
                if(currNode.right!=null){
                    queue.add(currNode.right);
                }
                currSize-=1;
            }
        }
        return leftAns;
    }
}