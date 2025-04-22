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
    public int maxPathSum(TreeNode root) {
        int maxValue[]=new int[1];
        maxValue[0]=Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }
    private int maxPathDown(TreeNode node,int maxValue[]){
        if(node==null){
            return 0;
        }
        int left=Math.max(0,maxPathDown(node.left,maxValue));
        int right=Math.max(0,maxPathDown(node.right,maxValue));
        maxValue[0]=Math.max(maxValue[0],left+right+node.val);
        return Math.max(left,right)+node.val;

    }
}


// class Solution { //TC O(N) SC O(N)
//     public int maxPathSum(TreeNode root) {
//         Map<TreeNode, Integer> nodeToMaxGain = new HashMap<>();
//         Stack<TreeNode> stack = new Stack<>();
//         Set<TreeNode> visited = new HashSet<>();
//         int maxSum = Integer.MIN_VALUE;
//         stack.push(root);
//         while (!stack.isEmpty()) {
//             TreeNode node = stack.peek();
//             // Post-order traversal: process children first
//             if (node.left != null && !visited.contains(node.left)) {
//                 stack.push(node.left);
//             } else if (node.right != null && !visited.contains(node.right)) {
//                 stack.push(node.right);
//             } else {
//                 stack.pop();
//                 visited.add(node);

//                 int leftGain = Math.max(0, nodeToMaxGain.getOrDefault(node.left, 0));
//                 int rightGain = Math.max(0, nodeToMaxGain.getOrDefault(node.right, 0));

//                 int currentMax = node.val + leftGain + rightGain;
//                 maxSum = Math.max(maxSum, currentMax);
//                 // Store the max gain if continuing the path through this node (one side only)
//                 nodeToMaxGain.put(node, node.val + Math.max(leftGain, rightGain));
//             }
//         }

//         return maxSum;
//     }
// }
