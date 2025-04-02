class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        helper(result,"",n,n);
        return result;
    }
    public void helper(List<String> result,String curr,int left,int right){
        if(left<0 || left>right){
            return;
        }
        if(left==0 && right==0){
            result.add(curr);
            return;
        }
        helper(result,curr+"(",left-1,right);
        helper(result,curr+")",left,right-1);
    }
}