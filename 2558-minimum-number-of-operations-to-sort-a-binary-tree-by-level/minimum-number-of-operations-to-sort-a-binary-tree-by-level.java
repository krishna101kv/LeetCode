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
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0; // Handle null root case
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cnt = 0;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            int[] arr1 = new int[levelSize];
            int[] arr2 = new int[levelSize];
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.remove();
                arr1[i] = currNode.val;
                arr2[i] = currNode.val;
                
                if (currNode.left != null) q.add(currNode.left);
                if (currNode.right != null) q.add(currNode.right);
            }
            
            cnt += calculateSwaps(arr1, arr2);
        }
        return cnt;
    }

    static int calculateSwaps(int[] arr1, int[] arr2) {
        int len = arr1.length;
        if (len == 1) return 0;

        Arrays.sort(arr1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr1[i], i);
        }

        boolean[] visited = new boolean[len];
        int swaps = 0;

        for (int i = 0; i < len; i++) {
            if (visited[i] || map.get(arr2[i]) == i) {
                continue;
            }
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = map.get(arr2[j]);
                cycleSize++;
            }
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        return swaps;
    }
}