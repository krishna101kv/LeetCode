class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lsum=new int[nums.length];
        int[] rsum=new int[nums.length];
        lsum[0]=1;
        rsum[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            lsum[i]=lsum[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            rsum[i]=rsum[i+1]*nums[i+1];
        }
        int[] fsum=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            fsum[i]=lsum[i]*rsum[i];
        }
        return fsum;
    }
}