class Solution {
    public int maxPower(String s) {
        int l=0,r=1,maxlen=1,n=s.length();
        while(r<n){
            if(s.charAt(l)==s.charAt(r)){
                maxlen=Math.max(r-l+1,maxlen);
            }else{
                l=r;
            }
            r++;
        }
        return maxlen;
    }
}