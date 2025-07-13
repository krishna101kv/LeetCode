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
        HashMap<TreeNode, TreeNode> parentMap=findParents(root);
        return findNodesAtK(root, target,k,parentMap);
    }
    private HashMap<TreeNode, TreeNode> findParents(TreeNode root){
        HashMap<TreeNode, TreeNode> parentMap=new HashMap<>();
        iterateTree(root,null,parentMap);
        return parentMap;
    }
    private void iterateTree(TreeNode currNode, TreeNode currParent,HashMap<TreeNode, TreeNode> parentMap){
        if(currNode==null){
            return ;
        }
        parentMap.put(currNode,currParent);
        iterateTree(currNode.left,currNode,parentMap);
        iterateTree(currNode.right,currNode,parentMap);
        return;
    }
    private List<Integer> findNodesAtK(TreeNode root,TreeNode target,int k,HashMap<TreeNode,TreeNode> parentMap){
        HashSet<TreeNode> visited=new HashSet<>();
        List<Integer> ans=new ArrayList<>();
        iterateTree(target,k,parentMap,visited,ans);
        return ans;
    }
    private void iterateTree(TreeNode current,int k,HashMap<TreeNode , TreeNode> parentMap, HashSet<TreeNode> visited, List<Integer> ans){
        if(current==null || visited.contains(current)){
            return;
        }
        visited.add(current);
        if(k==0){
            ans.add(current.val);
            return;
        }
        iterateTree(current.left,k-1,parentMap,visited,ans);
        iterateTree(current.right,k-1,parentMap,visited,ans);
        iterateTree(parentMap.get(current),k-1,parentMap,visited,ans);
        return;
    }
}