//https://practice.geeksforgeeks.org/problems/mother-vertex/1/#

class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        boolean[]vis = new boolean[V];
        Stack<Integer>st = new Stack<>();
        
        for(int i=0; i < V;i++) {
            if(vis[i] == false) {
                dfs(adj,i,vis,st);
            }
        }
        
        
        int pmv = st.peek(); //potential mother vertex
        
        vis = new boolean[V];
        dfs(adj,pmv,vis);
        
        for(int i=0; i < V;i++) {
            if(vis[i] == false) {
                return -1;
            }
        }
        
        return pmv;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>>adj,int src,boolean[]vis) {
        vis[src] = true;
        
        for(int nbr : adj.get(src)) {
            if(vis[nbr] == false) {
                dfs(adj,nbr,vis);
            }
        }
        
    }
    
    public void dfs(ArrayList<ArrayList<Integer>>adj,int src,boolean[]vis,Stack<Integer>st) {
        vis[src] = true;
        
        for(int nbr : adj.get(src)) {
            if(vis[nbr] == false) {
                dfs(adj,nbr,vis,st);
            }
        }
        
        st.push(src);
    }
}