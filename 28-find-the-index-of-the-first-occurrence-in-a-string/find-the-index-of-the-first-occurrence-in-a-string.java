class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        for(int i=0;i<=m-n;i++){
            for(int j=0;j<n;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
                if(j==(n-1)){       //Crucial: if the inner loop iterates for n times without breaking it means we found the substring and we need to return the i ie start point.
                    return i;
                }
            }
        }
        return -1;
    }
}