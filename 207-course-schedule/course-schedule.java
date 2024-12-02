class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int v=numCourses;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        
        for(int pre[]:prerequisites)
            adj.get(pre[1]).add(pre[0]);
        
        int indegree[]=new int[v];
        for(int i=0;i<v;i++){
            for(int it:adj.get(i))
                indegree[it]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.remove();
            topo.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }
        }
        if(topo.size()==v)
            return true;
        return false;
    }
}