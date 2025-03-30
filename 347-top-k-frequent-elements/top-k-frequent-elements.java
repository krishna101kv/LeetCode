class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length ==0 ){
            return new int[k];
        }
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a) - map.get(b));
        for(int n : map.keySet()){
            pq.add(n);
            if(pq.size()>k){
                pq.remove();
            }
        }
        int[] ans=new int[k];
        int i=0;
        while(pq.size() !=0){
            ans[i++]=pq.peek();
            pq.remove();
        }
        return ans;
    }
}