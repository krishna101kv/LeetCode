class Solution {
    public int mySqrt(int x) {
        long temp=x;
        while(temp*temp>x){
           temp=(temp+x/temp)/2;
        }
        return (int)temp;
    }
}