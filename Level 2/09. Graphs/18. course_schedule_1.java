class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[]graph = new ArrayList[numCourses];
        
        for(int i=0; i < numCourses;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i < prerequisites.length;i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            graph[u].add(v);
        }
        
        
        int[]ans = kahn(graph);
        
        if(ans.length == 0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    
    public int[] kahn(ArrayList<Integer>[]graph) {
        int n = graph.length;
        
        //create indegree array
        int[]indegree = new int[n];
        
        for(int i = 0; i < graph.length;i++) {
            for(int nbr : graph[i]) {
                indegree[nbr]++;
            }
        }
        
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        for(int i=0; i < n;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        
        ArrayList<Integer>list = new ArrayList<>();
        
        while(q.size() > 0) {
            int rem = q.remove();
            list.add(rem);
            
            for(int nbr : graph[rem]) {
                indegree[nbr]--;
                
                if(indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }
        
        
        
        if(list.size() == n) {
            //valid topological sort is present in this graph
            int[]ts = new int[n];
            for(int i=0; i < n;i++) {
                ts[i] = list.get(i);
            }
            return ts;
        }
        else {
            int[]arr = {};
            return arr;
        }
         
    }
    
}