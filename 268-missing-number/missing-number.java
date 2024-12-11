class Solution {
    public int missingNumber(int[] nums) {
        int xor1=0,xor2=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            xor1=nums[i]^xor1;
            xor2=i^xor2;
        }
        xor2=xor2^n;
        return xor2^xor1;
    }
}
// Can be done using sum of all numbers that is n*n+1 and then substracte it to find the missing //numbers