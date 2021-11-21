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
        int wsf;
        String psf;

        Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
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
        int dest = Integer.parseInt(br.readLine());

        int criteria = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];
        multisolver(graph, src, dest, visited, criteria, k, src + "", 0);

        System.out.println("Smallest Path = " + spath + "@" + spathwt);
        System.out.println("Largest Path = " + lpath + "@" + lpathwt);
        System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
        System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
        System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
    }



    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue < Pair > pq = new PriorityQueue < > ();

    public static void multisolver(ArrayList < Edge > [] graph, int src, int dest, boolean[] vis, int criteria, int k, String psf, int wsf) {

        if (src == dest) {
            //smallest
            if (wsf < spathwt) {
                spathwt = wsf;
                spath = psf;
            }

            //largest
            if (wsf > lpathwt) {
                lpathwt = wsf;
                lpath = psf;
            }

            //ceil - qualified min
            if (wsf > criteria && cpathwt > wsf) {
                cpathwt = wsf;
                cpath = psf;
            }

            //floor - qualified max
            if (wsf < criteria && fpathwt < wsf) {
                fpathwt = wsf;
                fpath = psf;
            }

            //kth largest
            if (pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else if (pq.peek().wsf < wsf) {
                pq.remove();
                pq.add(new Pair(wsf, psf));
            }

            return;
        }

        vis[src] = true;

        for (Edge edge: graph[src]) {
            int nbr = edge.nbr;
            int wt = edge.wt;

            if (vis[nbr] == false) {
                multisolver(graph, nbr, dest, vis, criteria, k, psf + nbr, wsf + wt);
            }
        }

        vis[src] = false;
    }
}