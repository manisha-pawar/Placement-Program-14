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


    public static boolean isCompCyclic(ArrayList < Edge > [] graph, int src, boolean[] vis) {
        ArrayDeque < Integer > q = new ArrayDeque < > ();
        q.add(src);

        while (q.size() > 0) {
            //remove
            int rem = q.remove();

            //mark*
            if (vis[rem] == true) {
                return true;
            }
            vis[rem] = true;

            //add unvisited nbr
            for (Edge edge: graph[rem]) {
                int nbr = edge.nbr;
                if (vis[nbr] == false) {
                    q.add(nbr);
                }
            }
        }

        return false;

    }

    public static boolean isGraphCyclic(ArrayList < Edge > [] graph) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == false) {
                boolean sca = isCompCyclic(graph, i, vis);

                if (sca == true) {
                    return true;
                }
            }
        }
        return false;
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
        System.out.println(isGraphCyclic(graph));
    }
}