class Solution {
    public int search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>=nums[end]){
                if(nums[start]<=target && target<=nums[mid]){
                    end=mid-1;
                }else{
                       start=mid+1;
                }  
            }
            else{
                 if(nums[end]>=target && target>=nums[mid]){
                    
                    start=mid+1;
                }else{
                    end=mid-1;
                }  
            }
        }
        return -1;
    }
}
