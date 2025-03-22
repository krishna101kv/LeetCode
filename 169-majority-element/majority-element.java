class Solution {
    //Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int max=0;
        int k=nums[0];
        for(int i=0;i<nums.length;i++){
            if(max==0){
                k=nums[i];
            }if(nums[i]==k){
                max++;
            }else{
                max--;
            }
        }
        return k;
    }
}