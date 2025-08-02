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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postIndex={postorder.length-1};
        HashMap<Integer,Integer> inorderMap=buildMap(inorder);
        return constructTrees(postorder,inorder,postIndex,0,inorder.length-1,inorderMap);
    }
    public TreeNode constructTrees(int[] postorder,int[] inorder, int[] postIndex,int inStart,int inEnd,
    HashMap<Integer,Integer> inorderMap){
        if(postIndex[0]<0 || inStart>inEnd){
            return null;
        }
        int currVal=postorder[postIndex[0]];
        TreeNode currNode=new TreeNode(currVal);

        postIndex[0]-=1;
        int i=inorderMap.get(currVal);
        currNode.right=constructTrees(postorder,inorder,postIndex,i+1,inEnd,inorderMap);
        currNode.left=constructTrees(postorder,inorder,postIndex,inStart,i-1,inorderMap);
        return currNode;
    }
    public HashMap<Integer,Integer> buildMap(int[] inorder){
        HashMap<Integer,Integer> inorderMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return inorderMap;
    }
}