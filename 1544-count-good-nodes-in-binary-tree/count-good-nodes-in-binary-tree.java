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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    public int dfs(TreeNode root, int maxSoFar) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val >= maxSoFar) {
            res = 1;
        }
        int newMax = Math.max(maxSoFar, root.val);
        res += dfs(root.left, newMax);
        res += dfs(root.right, newMax);
        return res;
    }
}
