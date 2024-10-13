class Solution {
    public int lengthOfLongestSubstring(String s) {
        int currLen=0,maxLen=0;
        int i=0,j=-1;
        boolean[] set=new boolean[256];
        while(i<s.length()){
            char cTA=s.charAt(i);
            while(set[cTA]==true){
                j++;
                char cTR=s.charAt(j);
                set[cTR]=false;
            }
            set[cTA]=true;
            maxLen=Math.max(maxLen,i-j);
            i++;
        }
        return maxLen;
        
    }
}
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         int ans=0;
//         int rel=0;
//         for(int i=0;i<s.length();i++) {
//             Character ch=s.charAt(i);
//             if(map.containsKey(ch) && map.get(ch)>=rel){
//                 rel=map.get(ch)+1;
//             }
//             map.put(ch,i);
//             ans=Math.max(ans,i-rel+1);
//         }
//         return ans;
//     }
// }
