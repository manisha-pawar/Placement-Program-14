import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;

public class Main {
    static class Edge {
        int u;
        int v;
        int wt;
        
        Edge() {
            
        }
        
        Edge(int u,int v,int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    
	public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); //vertices
        int edges = scn.nextInt(); //edges
        
        int temp = edges;
        ArrayList<Edge>[]graph = new ArrayList[n];
        
        for(int i=0; i < n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        while(temp-- > 0) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();
            
            u--;v--;
            
            graph[u].add(new Edge(u,v,wt));
        }
        
        int[]ans = bellmanford(graph,0);
        
        for(int i=1; i < ans.length;i++) {
            System.out.print(ans[i] + " ");
        }
	}
	
	
	
	public static int[] bellmanford(ArrayList<Edge>[]graph,int src) {
	    int[]path = new int[graph.length];
	    Arrays.fill(path,Integer.MAX_VALUE);
	    path[src] = 0;
	    
	    //v-1 iterations
	    for(int itr = 1; itr <= graph.length-1; itr++) {
	        //edges
	        for(int i=0; i < graph.length;i++) {
	            for(Edge edge : graph[i]) {
	                int u = edge.u;
	                int v = edge.v;
	                int wt = edge.wt;
	                
	                if(path[u] != Integer.MAX_VALUE && path[u] + wt < path[v]) {
	                    path[v] = path[u] + wt;
	                }
	            }
	        }
	        
	    }
	    
	    return path;
	}
}
