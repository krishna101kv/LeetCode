class Solution {
    public int firstUniqChar(String s) {
        int index=-1;
        Map<Character,Integer> charFrequency=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            charFrequency.put(ch,charFrequency.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(charFrequency.get(ch)==1){
                index=i;
                break;
            }
        }
        return index;
    }
}