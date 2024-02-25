class Solution {
    public int findPeakElement(int[] nums) {
        // int s=0;
        // int e=nums.length-1;
        // while(s<e){
        //     int m=s+ (e-s)/2;
        //     if(nums[m]>nums[m+1]){
        //         e=m;
        //     }
        //     else{   
        //         s=m+1;
        //     }
        // }
        // return s;
        if(nums.length==1){
            return 0;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        int start=1,end=nums.length-2;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                return mid;
            }
            else if(nums[mid]>nums[mid-1]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}