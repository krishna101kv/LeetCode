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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<Double> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int currLevel=queue.size();
            int count=currLevel;
            double sumOfNodes=0;
            while(currLevel>0){
                TreeNode currNode=queue.remove();
                sumOfNodes+=currNode.val;
                if(currNode.left!=null){
                    queue.add(currNode.left);
                }
                if(currNode.right!=null){
                    queue.add(currNode.right);
                }
                currLevel-=1;
            }
            ans.add(sumOfNodes/count);
        }
        return ans;
    }
}