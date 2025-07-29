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
 //ON SC:ON
class Solution{
     public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root=buildTrees(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
        return root;
    }
    public TreeNode buildTrees(int[] preorder,int preStart,int preEnd, int[] inorder, int inStart, int inEnd, 
    Map<Integer,Integer> inMap){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int inRoot=inMap.get(root.val);
        int numsLeft=inRoot-inStart;

        root.left= buildTrees(preorder,preStart+1,preStart + numsLeft,inorder,inStart,inRoot-1,inMap);
        root.right= buildTrees(preorder,preStart+ numsLeft +1, preEnd ,inorder , inRoot+1, inEnd,inMap);
        return root;
    }
}
 //On2
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         int[] preIndex={0};
//         return constructTrees(preorder,inorder,preIndex,0,inorder.length);
//     }
//     public TreeNode constructTrees(int[] preorder, int[] inorder,int[] preIndex, int inStart, int inEnd){
//         if(preIndex[0]>=preorder.length || inStart>inEnd){
//             return null;
//         }

//         int currVal= preorder[preIndex[0]];
//         TreeNode currNode=new TreeNode(currVal);
//         int i=-1;
//         preIndex[0]+=1;
//         for(i=inStart;i<inEnd;i++){
//             if(inorder[i]==currVal){
//                 break;
//             }
//         }

//         currNode.left=constructTrees(preorder,inorder,preIndex,inStart,i-1);
//         currNode.right=constructTrees(preorder,inorder,preIndex,i+1,inEnd);

//         return currNode;
//     }
// }