class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> graph)
    {
        //1. perform dfs and fill the nodes in post-order in the stack
        Stack<Integer>st = new Stack<>();
        boolean[]vis = new boolean[V];
        
        for(int i=0; i < V;i++) {
            if(vis[i] == false) {
                dfs(i,graph,vis,st);
            }
        }
        
        
        //2. reverse the graph
        ArrayList<ArrayList<Integer>>revGraph = new ArrayList<>();
        
        for(int i=0;i < V;i++) {
            revGraph.add(new ArrayList<>());
        }
        
        for(int u=0; u < V;u++) {
            for(int v : graph.get(u)) {
                revGraph.get(v).add(u);
            }
        }
        
        
        //3. perform dfs on this revGraph using order present in stack
        int scc = 0;
        vis = new boolean[V];
        
        while(st.size() > 0) {
            int src = st.pop();
            
            if(vis[src] == false) {
                scc++;
                dfs(src,revGraph,vis);
            }
        }
        
        return scc;
        
    }
    
    public void dfs(int src,ArrayList<ArrayList<Integer>>graph,boolean[]vis,Stack<Integer>st) {
        vis[src] = true;
        
        for(int nbr : graph.get(src)) {
            if(vis[nbr] == false) {
                dfs(nbr,graph,vis,st);
            }
        }
        
        st.push(src);
    }
    
    public void dfs(int src,ArrayList<ArrayList<Integer>>graph,boolean[]vis) {
        vis[src] = true;
        
        for(int nbr : graph.get(src)) {
            if(vis[nbr] == false) {
                dfs(nbr,graph,vis);
            }
        }
        
    }
    
}
