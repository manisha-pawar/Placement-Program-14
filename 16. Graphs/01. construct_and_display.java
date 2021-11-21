import java.util.*;

public class Main {
    public static class Edge {
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
    
    public static void addEdge(ArrayList<Edge>[]graph,int u,int v,int wt) {
        Edge e1 = new Edge(u,v,wt);
        Edge e2 = new Edge(v,u,wt);
        
        graph[u].add(e1);
        graph[v].add(e2);
    }
    
    public static void display(ArrayList<Edge>[]graph) {
        for(int i=0; i < graph.length;i++) {
            System.out.print(i + " -> ");
            for(int j=0; j < graph[i].size();j++) {
                Edge edge = graph[i].get(j);
                
                System.out.print(edge.u + "-" + edge.v + "@" + edge.wt+ ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[]args) {
        int vtx = 7; //total vertices
        int edges = 8; //total edges
        
        ArrayList<Edge>[]graph = new ArrayList[vtx];
        
        for(int i=0; i < graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
        
        addEdge(graph,0,3,40);
        addEdge(graph,0,1,10);
        addEdge(graph,1,2,10);
        addEdge(graph,2,3,10);
        addEdge(graph,3,4,8);
        addEdge(graph,4,5,6);
        addEdge(graph,5,6,2);
        addEdge(graph,4,6,5);
        
        display(graph);
    }
}