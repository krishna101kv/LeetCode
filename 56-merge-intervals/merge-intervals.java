import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->
                       Integer.compare(a[0],b[0]));
        ArrayList<int[]> list=new ArrayList<>();
        for(int[] interval:intervals){
            if(list.size()==0){
                list.add(interval);
            }
            int[] prevInterval=list.get(list.size()-1);
            if(interval[0]<=prevInterval[1]){
                prevInterval[1]=Math.max(interval[1],prevInterval[1]);
            }
            else{
                list.add(interval);
            }
        }
        return list.toArray(new int[list.size()][]);
        
    }
}