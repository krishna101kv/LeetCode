class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxSum=0,lsum=0,rsum=0;
        for(int i=0;i<k;i++){
            lsum=lsum+cardPoints[i];
        }
        maxSum=lsum;
        System.out.println(maxSum);
        int r=cardPoints.length-1;
        for(int j=k-1;j>=0;j--){
            
            lsum=lsum-cardPoints[j];
            rsum=rsum+cardPoints[r];
            r--;
            maxSum=Math.max(maxSum,(lsum+rsum));
        }
        return maxSum;
    }
}