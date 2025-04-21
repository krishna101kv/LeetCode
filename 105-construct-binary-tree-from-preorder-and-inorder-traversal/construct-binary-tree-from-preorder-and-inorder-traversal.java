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

 //On2
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex={0};
        return constructTrees(preorder,inorder,preIndex,0,inorder.length);
    }
    public TreeNode constructTrees(int[] preorder, int[] inorder,int[] preIndex, int inStart, int inEnd){
        if(preIndex[0]>=preorder.length || inStart>inEnd){
            return null;
        }

        int currVal= preorder[preIndex[0]];
        TreeNode currNode=new TreeNode(currVal);
        int i=-1;
        preIndex[0]+=1;
        for(i=inStart;i<inEnd;i++){
            if(inorder[i]==currVal){
                break;
            }
        }

        currNode.left=constructTrees(preorder,inorder,preIndex,inStart,i-1);
        currNode.right=constructTrees(preorder,inorder,preIndex,i+1,inEnd);

        return currNode;
    }
}