class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos=new ArrayList<>();
        List<Integer> neg=new ArrayList<>();
        //List<integer> ans=new ArrayList<>();
        for(int num:nums){
            if(num>0){
                pos.add(num);
            }else{
                neg.add(num);
            }
        }
        int posS=0;
        int negS=0;
        for(int i=0;i<nums.length;i++){
         if(i%2==0){
                
                nums[i]=pos.get(posS++);
                //posS++;
            }
            else{
                nums[i]=neg.get(negS++);

            }

        }
        return nums;

        
    }
}