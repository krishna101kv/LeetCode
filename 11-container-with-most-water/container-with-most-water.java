class Solution {
    public int maxArea(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int max=0;
        while(i<j){
            int currArea=(j-i)*Math.min(nums[i],nums[j]);
             max=Math.max(max,currArea);
            if(nums[i]<nums[j]){
                i++;
            }
            else{
                j--;
            }
           

        }
        return max;
    }
}