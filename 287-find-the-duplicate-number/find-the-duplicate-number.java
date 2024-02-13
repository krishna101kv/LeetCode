class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0],fast=nums[0];
        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(fast==slow){
                break;
            }
        } 
        int start=nums[0];
        while(start!=slow){
            slow=nums[slow];
            start=nums[start];
        }
        return start;

        
    }
}