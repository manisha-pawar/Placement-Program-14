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

    public static class Pair {
        int v;
        int sn;

        Pair() {

        }

        Pair(int v, int sn) {
            this.v = v;
            this.sn = sn;
        }
    }

    public static boolean isCompBipartite(int src, ArrayList < Edge > [] graph, int[] vis) {
        ArrayDeque < Pair > q = new ArrayDeque < > ();
        q.add(new Pair(src, 0));

        while (q.size() > 0) {
            Pair rem = q.remove();

            if (vis[rem.v] != -1) {
                int osn = vis[rem.v]; //old set number
                int nsn = rem.sn; //new set number

                if (osn != nsn) {
                    return false;
                }
                continue;
            }
            vis[rem.v] = rem.sn;

            for (Edge edge: graph[rem.v]) {
                int nbr = edge.nbr;

                if (vis[nbr] == -1) {
                    int sn = (rem.sn == 0) ? 1 : 0;
                    q.add(new Pair(nbr, sn));
                }
            }
        }

        return true;
    }
    public static boolean isGraphBipartite(ArrayList < Edge > [] graph) {
        int[] vis = new int[graph.length];
        Arrays.fill(vis, -1);

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == -1) {
                boolean sca = isCompBipartite(i, graph, vis);

                if (sca == false) {
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
        System.out.println(isGraphBipartite(graph));
    }
}