class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb=new StringBuilder();
        int ct=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                sb.append(c);
                ct++;
            }
            else if(c==')' && ct>0){
                sb.append(c);
                ct--;
            }
            else if(c!=')'){
                sb.append(c);
            }
        }
        StringBuilder filter=new StringBuilder();
        for(int i=sb.length()-1;i>=0;i--){
            char c=sb.charAt(i);
            if(c=='(' && ct>0){
                ct--;
            }
            else{
                filter.append(c);
            }
        }
        filter.reverse();
        return filter.toString(); 
    }
}