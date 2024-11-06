class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String> invalid=new HashSet<>();
        for(String s:forbidden){
            invalid.add(s);
        }
        int n=word.length();
        int left=n-1,right=left;

        int maxLen=0;
        while(left>-1){
            //for(int i=left;i<=right;i++) This will work but we add so that it only takes length of 10
            for(int i=left;i<=Math.min(right,left+9);i++){
                String substring=word.substring(left,i+1);
                if(invalid.contains(substring)){
                    right=i-1;
                    break;
                }

            }
            maxLen=Math.max(maxLen,right-left+1);
            left--;
        }
        return maxLen;   
    }
}