//single source all destination shortest path

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

    public static class Pair implements Comparable < Pair > {
        int v;
        int wsf;
        String psf;

        Pair() {

        }

        Pair(int v, int wsf, String psf) {
            this.v = v;
            this.wsf = wsf;
            this.psf = psf;
        }

        //this < o -> -ve
        //this > o -> +ve
        //this == o -> 0 
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }

    }

    public static void dijkstra(ArrayList < Edge > [] graph, int src) {
        //single src to all dest - shortest path(wt)
        boolean[] vis = new boolean[graph.length];

        PriorityQueue < Pair > pq = new PriorityQueue < > ();
        pq.add(new Pair(src, 0, "" + src));

        while (pq.size() > 0) {
            //remove
            Pair rem = pq.remove();

            //mark*
            if (vis[rem.v] == true) {
                continue;
            }
            vis[rem.v] = true;

            //work
            System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);

            //add nbr*
            for (Edge edge: graph[rem.v]) {
                int nbr = edge.nbr;
                int wt = edge.wt;

                if (vis[nbr] == false) {
                    pq.add(new Pair(nbr, rem.wsf + wt, rem.psf + nbr));
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

        int src = Integer.parseInt(br.readLine());
        dijkstra(graph, src);

    }
}