import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void travel(int src, ArrayList < Edge > [] graph, boolean[] vis) {
        vis[src] = true;

        for (Edge edge: graph[src]) {
            int nbr = edge.nbr;

            if (vis[nbr] == false) {
                travel(nbr, graph, vis);
            }
        }
    }

    
    public static boolean isGraphConnected(ArrayList < Edge > [] graph) {
        boolean[] vis = new boolean[graph.length];
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == false) {
                travel(i, graph, vis);
                count++;

                if (count > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        // write your code here
        System.out.println(isGraphConnected(graph));


    }
}