class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        while(left<right){
            int sum=numbers[left]+numbers[right];
            if(sum==target){
                int res[]={left+1,right+1};
                return res;
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
         int res[]={-1};
        return res;
        
    }
}