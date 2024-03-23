class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1=word1.length();
        int w2=word2.length();
        String f="";
        int s= w1+w2;
        int c1=0,c2=0;
        for(int i=0;i<s;i++){
                if(w1!=c1){
                    char c3=word1.charAt(c1);
                    f+=c3;
                    c1++;
                }
                if(w2!=c2){
                    char c4=word2.charAt(c2);
                    f+=c4;
                    c2++;
                }
        }
        return f;
    }
}