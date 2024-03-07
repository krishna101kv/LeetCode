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

// class Solution {
//     public int search(int[] nums, int target) {
        
//         int p=findPivot(nums);
//         if(p== -1){
//             return Binary(nums,target,0,nums.length-1);
//         }
//         if(nums[p]==target){
//            return p;
//         }
//         if(target>=nums[0]){
//             return Binary(nums,target,0,p-1);
            
//         }
//             return Binary(nums,target,p+1,nums.length-1);
        
        
//     }
//      int Binary(int[] nums,int target,int start,int end){
//         while(start<=end){
//             int m=start+(end-start)/2;
//             if(target<nums[m]){
//                 end=m-1;
//             }
//             else if(target>nums[m]){
                
//                 start=m+1;
//             }
//             else{
//                 return m;
//             }
//         }
//          return -1;
//     }
//     int findPivot(int[] nums){
//         int s=0;
//         int e=nums.length-1;
//         while(s<=e){
//             int mid=s+(e-s)/2;
//             if(mid<e && nums[mid]>nums[mid+1]){
//                 return mid;
//             }
//             if(mid>s && nums[mid]<nums[mid-1]){
//                 return mid-1;
//             }
//             if(nums[mid]<=nums[s]){
//                 e=mid-1;
//             }
//             else{
//                 s=mid+1;
//             }
//         }
//         return -1;
//     }
// }