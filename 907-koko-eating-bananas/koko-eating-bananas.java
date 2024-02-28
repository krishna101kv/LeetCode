class Solution {
    public int hourly(int[] arr,int h){
        int total=0;
        for(int i=0;i<arr.length;i++){
            total+=Math.ceil((double)arr[i]/(double)h);
        }
        return total;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=piles[0];
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }
        while(low<=high){
            int mid=(low+high)/2;
            int total=hourly(piles,mid);
            if(total<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}