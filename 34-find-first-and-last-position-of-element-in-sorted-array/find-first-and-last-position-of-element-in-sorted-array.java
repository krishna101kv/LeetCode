class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=binSearch(nums,target,true);
        int right=binSearch(nums,target,false);
        return new int[]{left,right};
    }
    public static int binSearch(int[] nums, int target, boolean isleft){
        int s=0;
        int e=nums.length-1;
        int i=-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(nums[m]>target){
                e=m-1;
            }
            else if(nums[m]< target){
                s=m+1;
            }
            else{
                i=m;
                if(isleft){
                    e=m-1;
                }
                else{
                    s=m+1;
                }
            }
        }
        return i;
    }
}
 //  int[] a={-1,-1};
        // for(int i=0;i<nums.length;i++){
        //         if(nums[i]==target){
        //                 a[0]=i;
        //                 break;
        //         }
        // }
        // for(int i=nums.length-1;i>=0;i--){    
        //     if(nums[i]==target){ 
        //         a[1]=i;
        //         break;
        //     }
               
        // }
        // return a;