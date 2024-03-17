class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int w=0;
        while(i<j){
            int b=j-i;
            //int min=0;
            int h=Math.min(height[i],height[j]);
            w=Math.max(w,h*b);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
            
        }
        return w;
    }
}