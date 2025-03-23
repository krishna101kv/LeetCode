class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int s:set){
            if(!set.contains(s-1)){
                int len=0;
                while(set.contains(s+len)){
                    len+=1;
                }
                max=Math.max(max,len);
            }
        }
        return max;
    }
}