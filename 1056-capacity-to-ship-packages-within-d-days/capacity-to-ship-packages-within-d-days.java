class Solution {
    public int findDays(int[] weights, int cap ){
        int days=1,load=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]  + load > cap){
                days++;
                load=weights[i];
            }else{
                load+=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum=0,max=weights[0];
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            max=Math.max(max,weights[i]);
        }
        int low=max;
        int high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            int noOfDays=findDays(weights,mid);
            if(noOfDays<=days){
                high=mid-1;

            }else{
                low=mid+1;
            }
        }
        return low;
        
    }
}