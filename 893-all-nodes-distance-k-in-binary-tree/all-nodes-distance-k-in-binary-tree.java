/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        // Step 1: BFS to map parents
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }

        // Step 2: BFS from target to find nodes at distance k
        queue.offer(target);
        visited.add(target);
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && visited.add(node.left)) {
                    queue.offer(node.left);
                }
                if (node.right != null && visited.add(node.right)) {
                    queue.offer(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if (parent != null && visited.add(parent)) {
                    queue.offer(parent);
                }
            }
            distance++;
        }

        return result;
    }
}
