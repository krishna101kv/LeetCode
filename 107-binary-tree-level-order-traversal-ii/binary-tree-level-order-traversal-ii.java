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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int currSize=queue.size();
            List<Integer> currLevel=new ArrayList<>();
            for(int i=0;i<currSize;i++){
                TreeNode currNode=queue.remove();
                currLevel.add(currNode.val);
                if(currNode.left!=null){
                    queue.add(currNode.left);
                   // currVal.add(currNode.left.val);
                }
                if(currNode.right!=null){
                    queue.add(currNode.right);
                    //currVal.add(currNode.right.val);
                }

            }
            ans.add(currLevel);
        }
        Collections.reverse(ans);
        return ans;
    }
}