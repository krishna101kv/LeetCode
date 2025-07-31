class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubset(nums, 0, new ArrayList<>(), ans);
        return ans;

    }

    public void generateSubset(int[] nums, int currIndex, ArrayList<Integer> currSubset, List<List<Integer>> ans) {
        if (currIndex >= nums.length) {
            ans.add(new ArrayList<>(currSubset));
            return;

        }

        currSubset.add(nums[currIndex]);
        generateSubset(nums, currIndex + 1, currSubset, ans);
        currSubset.remove(currSubset.size() - 1);
        generateSubset(nums, currIndex + 1, currSubset, ans);
        return;

    }
}