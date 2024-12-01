class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v=graph.length;
        int vis[]=new int[v];
        int pathVis[]=new int[v];
        int check[]=new int[v];
        for(int i=0;i<v;i++){
            if(vis[i]==0)
                dfs(i,graph,vis,pathVis,check);
        }
        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<v;i++){
            if(check[i]==1)
                safeNodes.add(i);
        }
        return safeNodes;
    }
    private boolean dfs(int node,int[][] graph,
   int[] vis,int[] pathVis,int[] check){
        vis[node]=1;
        pathVis[node]=1;
        check[node]=0;
        for(int it:graph[node]){
            if(vis[it]==0){
                if(dfs(it,graph,vis,pathVis,check)==true)
                    return true;
            }
            else if(pathVis[it]==1){
                return true;
            }
        }//If check[node]=1, the node is safe (not part of a cycle and does not lead to any cycle
        check[node]=1;
        pathVis[node]=0;
        return false;
   }
}