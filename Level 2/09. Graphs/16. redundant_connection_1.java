class Solution {
    
    int[]parent;
    int[]rank;
    
    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        
        int sl = find(parent[x]);
        parent[x] = sl;
        return sl;
    }
    
    public boolean union(int u,int v) {
        int sl1 = find(u);
        int sl2 = find(v);
        
        if(sl1 != sl2) {
            //merging
            if(rank[sl1] < rank[sl2]) {
                parent[sl1] = sl2;
            }
            else if(rank[sl2] < rank[sl1]) {
                parent[sl2] = sl1;
            }
            else {
                parent[sl1] = sl2;
                rank[sl2]++;
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        parent = new int[n+1];
        rank = new int[n+1];
        
        for(int i=1; i <= n;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int i=0; i < edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(union(u,v) == false) {
                int[]arr = {u,v};
                return arr;
            }
        }
        
        int[]arr = {0,0};
        return arr;
    }
}