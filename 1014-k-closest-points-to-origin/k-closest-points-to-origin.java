class Solution {
     public int[][] kClosest(int[][] points, int k) {
        int res[][]=new int[k][2];
        Queue<int[]> maxPQ=new PriorityQueue<>((a,b) -> squaredDistance(b) - squaredDistance(a));
        for(int[] point:points){
            maxPQ.add(point);
            if(maxPQ.size()>k){
                maxPQ.remove();
            }
        }
        int index=0;
        while(!maxPQ.isEmpty()){
            res[index]=maxPQ.remove();
            index++;
        }
        return res;
    }
    private int squaredDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}