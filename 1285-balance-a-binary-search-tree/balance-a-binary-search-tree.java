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
    public TreeNode balanceBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        if(root==null)
           return null;

        addLeftSubTree(root,stack);
        while(!stack.isEmpty()){
            TreeNode currNode=stack.pop();
            ans.add(currNode.val);
            if(currNode.right!=null){
                addLeftSubTree(currNode.right,stack);
            }
            
        }
        return arrayToBST(ans,0,ans.size()-1);
    }
        private void addLeftSubTree(TreeNode currNode, Stack<TreeNode> stack){
            stack.push(currNode);
            while(currNode.left!=null){
                stack.push(currNode.left);
                currNode=currNode.left;
            }
            return;
        }
        private TreeNode arrayToBST(List<Integer> nums,int start, int end){
            if(start>end){
                return null;
            }

            int mid=start+(end-start)/2;
            TreeNode newNode=new TreeNode(nums.get(mid),null,null);
            newNode.left=arrayToBST(nums,start,mid-1);
            newNode.right=arrayToBST(nums,mid+1,end);

            return newNode;
        } 
        
    }