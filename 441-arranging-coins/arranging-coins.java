class Solution {
    public int arrangeCoins(int n) {
        int s=1;
        int k=0;
        if(n==0){
            return 0;
        }
        for(int i=0;i<n;i++){
            n=n-s;
            s++;
            k++;
        }
        return k;
        
    }
}