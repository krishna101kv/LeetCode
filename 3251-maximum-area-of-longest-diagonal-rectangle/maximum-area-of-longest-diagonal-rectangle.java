class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxDiag = 0;

        for (int[] d : dimensions) {
            int x = d[0], y = d[1];
            int diagSq = x * x + y * y; // squared diagonal
            int area = x * y;

            if (diagSq > maxDiag) {
                maxDiag = diagSq;
                maxArea = area;
            } else if (diagSq == maxDiag) {
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
