class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        ArrayList<int[]> list=new ArrayList<>();
        int ptr1=0,ptr2=0;
        while(ptr1<firstList.length && ptr2<secondList.length){
            int sP=Math.max(firstList[ptr1][0],secondList[ptr2][0]);
            int eP=Math.min(firstList[ptr1][1],secondList[ptr2][1]);
            if(sP<=eP){
                int interval[]={sP,eP};
                list.add(interval);
            }
            if(firstList[ptr1][1]<secondList[ptr2][1]){
                ptr1++;
            }else{
                ptr2++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}