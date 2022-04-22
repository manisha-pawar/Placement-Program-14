class Solution
{
    
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[]path = new int[n];
        Arrays.fill(path,Integer.MAX_VALUE);
        path[0] = 0;
        
        //v-1 iteration
        for(int itr = 1; itr <= n-1; itr++) {
            for(int i=0; i < edges.length;i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];
                
                if(path[u] != Integer.MAX_VALUE && path[u] + wt < path[v]) {
                    path[v] = path[u] + wt;
                }
            }
        }
        
        
        //vth iteration
        for(int i=0; i < edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            if(path[u] != Integer.MAX_VALUE && path[u] + wt < path[v]) {
                return 1; //negative wt cycle is present
            }
        }
        
        
        return 0;
        
    }
}