class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        int maxlen=0;
        int i=0,j=0;
        Set<Character> set=new HashSet<>();
        while(j<len){
            if(!set.contains(s.charAt(j))){
                maxlen=Math.max(maxlen,j-i+1);
                set.add(s.charAt(j));
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxlen;
    }
}
