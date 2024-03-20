class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans=0;
        int rel=0;
        for(int i=0;i<s.length();i++) {
            Character ch=s.charAt(i);
            if(map.containsKey(ch) && map.get(ch)>=rel){
                rel=map.get(ch)+1;
            }
            map.put(ch,i);
            ans=Math.max(ans,i-rel+1);
        }
        return ans;
    }
}