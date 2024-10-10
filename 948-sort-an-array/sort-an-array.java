class Solution {
    public int[] sortArray(int[] nums) {
        int low=0;
        int high=nums.length-1;
        mergeSort(nums,low,high);
        return nums;
    }
    public void mergeSort(int[] nums,int low,int high){
        if(low>=high){
            return;
        }
         int mid=(low+high)/2;
         mergeSort(nums,low,mid);
         mergeSort(nums,mid+1,high);
         merge(nums,low,mid,high);
    }
    public void merge(int[] nums,int low,int mid,int high){
        ArrayList<Integer> arr=new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                arr.add(nums[left]);
                left++;
            }
            else{
                arr.add(nums[right]);
                right++;
            }
        }
        while(left<=mid){
            arr.add(nums[left]);
            left++;
        }
        while(right<=high){
            arr.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i]=arr.get(i-low);
        }
    }

}