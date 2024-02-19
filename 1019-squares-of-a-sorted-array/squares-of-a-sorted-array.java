class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left=0,right=nums.length-1;
        int leftsq, rightsq;
        for(int i=nums.length-1;i>=0;i--){
            leftsq=nums[left]*nums[left];
            rightsq=nums[right]*nums[right];
            if(leftsq > rightsq ){
                result[i]=leftsq;
                left++;
            }
            else{
                result[i]=rightsq;
                right--;
            }
        }
        return result;
        
    }
}