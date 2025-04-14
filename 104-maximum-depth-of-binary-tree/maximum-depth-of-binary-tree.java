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
        public int maxDepth(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        int h=0;
        if(root==null){
            return 0;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int currSize=queue.size();
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
            h+=1;
        }
        return h;
    }
    // public int maxDepth(TreeNode root) {
    //     return height(root);
        
    // }
    // public int height(TreeNode root){
    //     if(root==null){
    //         return 0;
    //     }
    //     int leftNode=height(root.left);
    //     int rightNode=height(root.right);
    //     return 1+Math.max(leftNode,rightNode);
    // }
}