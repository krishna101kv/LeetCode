class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int maxArea=0;
        while(i<j){
            int mh=Math.min(height[i],height[j]);
            int area=mh*(j-i);
            maxArea=Math.max(maxArea,area);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
}