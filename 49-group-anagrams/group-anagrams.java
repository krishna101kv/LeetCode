class Solution {
    private String freqString(String str){
        int[] freq=new int[26];
        for(char c:str.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        char c='a';
        for(int i:freq){
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length==0){
            return new ArrayList<>();
        }
        Map<String,List<String>> freqmap=new HashMap<>();
        for(String str:strs){
            String freqEncodedString=freqString(str);
            if(freqmap.containsKey(freqEncodedString)){
                freqmap.get(freqEncodedString).add(str);
            }else{
                List<String> strlist=new ArrayList<>();
                strlist.add(str);
                freqmap.put(freqEncodedString,strlist);
            }
        }
        return new ArrayList<>(freqmap.values());
    }
}