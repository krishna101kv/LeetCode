class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int area=0,maxArea=0;
        while(i<j){
            int l=Math.min(height[i],height[j]);
            area=(j-i)*l;
            maxArea=Math.max(area,maxArea);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
}