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

import java.util.Stack;

class Solution {
    // Helper class to store a node and the max value seen so far on the path
    static class NodeInfo {
        TreeNode node;
        int maxSoFar;

        NodeInfo(TreeNode node, int maxSoFar) {
            this.node = node;
            this.maxSoFar = maxSoFar;
        }
    }

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;

        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(root, root.val));
        int count = 0;

        while (!stack.isEmpty()) {
            NodeInfo current = stack.pop();
            TreeNode node = current.node;
            int maxSoFar = current.maxSoFar;

            if (node.val >= maxSoFar) {
                count++;
            }

            int newMax = Math.max(maxSoFar, node.val);
            if (node.right != null) {
                stack.push(new NodeInfo(node.right, newMax));
            }
            if (node.left != null) {
                stack.push(new NodeInfo(node.left, newMax));
            }
        }

        return count;
    }
}

