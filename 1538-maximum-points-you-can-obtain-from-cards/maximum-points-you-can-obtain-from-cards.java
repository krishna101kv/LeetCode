class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0,rsum=0,maxSum=0;
        int len=cardPoints.length;
        for(int i=0;i<k;i++){
            lsum=lsum+cardPoints[i];
        }
        maxSum=lsum;
        for(int i=k-1;i>=0;i--){
            lsum=lsum-cardPoints[i];
            rsum=rsum+cardPoints[len-1];
            len=len-1;
            maxSum=Math.max(maxSum,lsum+rsum);
        }
        return maxSum;
    }
}

 