class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0,r=0,maxLen=0,len=nums.length;
        while(r<len){
            if(nums[r]==1){
                maxLen=Math.max(maxLen,r-l+1);
            }else{
                l=r+1;
            }
            r++;
        }
        return maxLen;
    }
}