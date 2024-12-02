class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        
        for(int pre[]:prerequisites)
            adj.get(pre[1]).add(pre[0]);
        //// Build the graph (reverse prerequisites for adjacency list)
        int indegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i))
                indegree[it]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
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
        } // If all courses are processed, return true (no cycle)
        if(topo.size()!=numCourses)
            return new int[0];
        int res[]=new int[topo.size()];
        for(int i=0;i<topo.size();i++){
                res[i]=topo.get(i);
        }
        return res;
    }
}
