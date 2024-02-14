// class Solution {
//     public int[] rearrangeArray(int[] nums) {
//         List<Integer> pos=new ArrayList<>();
//         List<Integer> neg=new ArrayList<>();
//         for(int num:nums){
//             if(num>0){
//                 pos.add(num);
//             }else{
//                 neg.add(num);
//             }
//         }
//         int posS=0;
//         int negS=0;
//         for(int i=0;i<nums.length;i++){
//          if(i%2==0){
//                 nums[i]=pos.get(posS++);
//             }
//             else{
//                 nums[i]=neg.get(negS++);
//             }
//         }
//         return nums;
//     }
// }
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int p = 0, n = 1;
        int[] res = new int[nums.length];
        
        for(int i= 0;i<res.length;i++){
            if(nums[i]>0){
                res[p] = nums[i];
                p += 2;
            }
            else{
                res[n] = nums[i];
                n += 2;
            }
        }
        return res;
    }
}