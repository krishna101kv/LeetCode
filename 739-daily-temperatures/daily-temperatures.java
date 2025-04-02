class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> helperStack=new Stack<Integer>();
        int n=temperatures.length;
        int result[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!helperStack.isEmpty() && temperatures[i]>=temperatures[helperStack.peek()]){
                helperStack.pop();
            }
            if(!helperStack.isEmpty()){
                    result[i]=helperStack.peek()-i;
            }
            helperStack.push(i);
        }
        return result;
    }
}