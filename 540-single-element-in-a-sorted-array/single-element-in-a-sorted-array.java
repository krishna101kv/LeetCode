class Solution {
    public int singleNonDuplicate(int[] nums){
        int l=0,r=nums.length-1;
        if(nums.length==1){
            return nums[0];
        }else if(nums[0]!=nums[1]){
            return nums[0];
        }else if(nums[r]!=nums[r-1]){
            return nums[r];
        }
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]!=nums[m-1]&& nums[m+1]!=nums[m]){
                return nums[m];
            }
            else if((m%2==0 && nums[m]==nums[m+1]) || (m%2==1 && nums[m]==nums[m-1])){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return nums[nums.length-1];
    }
}