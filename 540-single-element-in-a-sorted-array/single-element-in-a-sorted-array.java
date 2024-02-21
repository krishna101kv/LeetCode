class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        
        for(int i=0,j=1;i<nums.length-1;i+=2,j+=2){
            if(nums[i]!=nums[j]){
                return nums[i];
            }

        }
        return nums[nums.length-1];
        
    }
}