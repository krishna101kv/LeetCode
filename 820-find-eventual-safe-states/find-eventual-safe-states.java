class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //Topo Sort
        int n=graph.length;
        List<List<Integer>> adjRev=new ArrayList<>(); 
        for(int i=0;i<n;i++){
            adjRev.add(new ArrayList<>());
        }
        int indegree[]=new int[n];
        for(int i=0;i<n;i++){
            for(int neighbor:graph[i]){
                adjRev.get(neighbor).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.remove();
            safeNodes.add(node);
            for(int it:adjRev.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
   }
}

//         int v=graph.length;
//         int vis[]=new int[v];
//         int pathVis[]=new int[v];
//         int check[]=new int[v];
//         for(int i=0;i<v;i++){
//             if(vis[i]==0)
//                 dfs(i,graph,vis,pathVis,check);
//         }
//         List<Integer> safeNodes=new ArrayList<>();
//         for(int i=0;i<v;i++){
//             if(check[i]==1)
//                 safeNodes.add(i);
//         }
//         return safeNodes;
//     }
//     private boolean dfs(int node,int[][] graph,
//    int[] vis,int[] pathVis,int[] check){
//         vis[node]=1;
//         pathVis[node]=1;
//         check[node]=0;
//         for(int it:graph[node]){
//             if(vis[it]==0){
//                 if(dfs(it,graph,vis,pathVis,check)==true)
//                     return true;
//             }
//             else if(pathVis[it]==1){
//                 return true;
//             }
//         }//If check[node]=1, the node is safe (not part of a cycle and does not lead to any cycle
//         check[node]=1;
//         pathVis[node]=0;
//         return false;