class Solution {
    public int minimumLength(String str) {
        int s=0;
        int e=str.length()-1;
        while(s<e && str.charAt(s)==str.charAt(e)){
            char curr=str.charAt(s);
            while(s<=e && str.charAt(s)==curr){
                s++;
            }
            while(s<=e && str.charAt(e)==curr){
                e--;
            }
        }
        return e-s+1;
        
    }
}