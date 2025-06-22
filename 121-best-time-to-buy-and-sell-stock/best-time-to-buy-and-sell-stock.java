class Solution {
    public int maxProfit(int[] prices) {
        int i=0,j=1,maxprice=0;
        while(j<prices.length){
            if(prices[i]<prices[j]){
                maxprice=Math.max(prices[j]-prices[i],maxprice);
                
            }else{
                i=j;
            }
            j++;
        }
        return maxprice;
    }
}