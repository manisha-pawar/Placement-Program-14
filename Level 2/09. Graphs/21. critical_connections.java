class Solution {
    int[]disc;
    int[]low;
    boolean[]ap;
    int time = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer>[]graph = new ArrayList[n];
        
        for(int i=0; i < n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i < connections.size();i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        List<List<Integer>>ans = new ArrayList<>();
        boolean[]vis = new boolean[n];
        
        disc = new int[n];
        low = new int[n];
        ap = new boolean[n];
        time = 0;
        
        bridge(graph,0,-1,vis,ans);
        
        return ans;
    }
    
    
    
    public void bridge(ArrayList < Integer > [] graph, int src, int par, boolean[] vis,List<List<Integer>>ans) {
        disc[src] = low[src] = time;
        vis[src] = true;
        time++;

        for (int nbr: graph[src]) {
            if (nbr == par) {
                //do nothing
            } 
            else if (vis[nbr] == true) {
                //nbr is visited
                low[src] = Math.min(low[src], disc[nbr]);
            } 
            else if (vis[nbr] == false) {
                bridge(graph, nbr, src, vis, ans);
                low[src] = Math.min(low[src], low[nbr]);

                //to check bridge
                if(disc[src] < low[nbr]) {
                   ArrayList<Integer>list= new ArrayList<>();
                    list.add(src);
                    list.add(nbr);
                    ans.add(list);
                }
            }
        }
    }
}