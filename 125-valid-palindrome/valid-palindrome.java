class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j = s.length()-1;
        while(i<j){
            Character start = s.charAt(i);
            Character end = s.charAt(j);
            if(!Character.isLetterOrDigit(start)){
                i++;
            }
            else if(!Character.isLetterOrDigit(end)){
                j--;
            }
            else{
                if(Character.toLowerCase(start)!=Character.toLowerCase(end)){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}