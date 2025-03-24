class Solution {
    public int missingNumber(int[] nums) {
        int res=0;
        int len=(nums.length*(nums.length+1))/2;
        for(int i=0;i<nums.length;i++){
            res+=nums[i];
        }
        return len-res;
    }
}
// Can be done using sum of all numbers that is n*n+1 and then substracte it to find the missing //numbers