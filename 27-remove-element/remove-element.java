class Solution {
    public int removeElement(int[] nums, int val) {
        int z=0;
        int len=nums.length;
        for(int j=0;j<len;j++){
            if(nums[j]!=val){
                int temp=nums[z];
                nums[z]=nums[j];
                nums[j]=temp;
                z++;
            }            
        }
        return z;
        
    }
}
