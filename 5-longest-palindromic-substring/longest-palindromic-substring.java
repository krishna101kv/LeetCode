class Solution {
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<=1){
            return s;
        }
        String lps="";
        for(int i=1;i<s.length();i++){
            int low=i;
            int high=i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low==-1 || high==len){
                    break;
                }
            }
            String pallindrone=s.substring(low+1,high);
            if(pallindrone.length()>lps.length()){
                lps=pallindrone;
            }
            low=i-1;
            high=i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low==-1 || high==len){
                    break;
                }
            }
            pallindrone=s.substring(low+1,high);
            if(pallindrone.length()>lps.length()){
                lps=pallindrone;
            }
        }
        return lps;
    }
}