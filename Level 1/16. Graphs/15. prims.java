//minimum spanning tree concept

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

    static class Pair implements Comparable < Pair > {
        int v;
        int aq;
        int wt;

        Pair() {

        }

        Pair(int v, int aq, int wt) {
            this.v = v;
            this.aq = aq;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }


    }


    public static void prims(ArrayList < Edge > [] graph) {
        PriorityQueue < Pair > pq = new PriorityQueue < > ();
        pq.add(new Pair(0, -1, 0));
        boolean[] vis = new boolean[graph.length];

        while (pq.size() > 0) {
            //remove
            Pair rem = pq.remove();

            //mark*
            if (vis[rem.v] == true) {
                continue;
            }
            vis[rem.v] = true;

            //work
            if (rem.aq != -1) {
                System.out.println("[" + rem.v + "-" + rem.aq + "@" + rem.wt + "]");
            }

            //add nbr*
            for (Edge edge: graph[rem.v]) {
                int nbr = edge.nbr;
                int wt = edge.wt;

                if (vis[nbr] == false) {
                    pq.add(new Pair(nbr, rem.v, wt));
                }
            }
        }
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
        prims(graph);
    }

}