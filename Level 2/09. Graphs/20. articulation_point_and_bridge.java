import java.util.*;
import java.io.*;

class Main {

    static int[] disc;
    static int[] low;
    static boolean[] ap;
    static int time = 0;
    static int osc = 0;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtx = scn.nextInt();
        int edges = scn.nextInt();

        int temp = edges;

        ArrayList < Integer > [] graph = new ArrayList[vtx];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList < > ();
        }

        while (temp-- > 0) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            u--;
            v--;

            graph[u].add(v);
            graph[v].add(u);
        }

        disc = new int[vtx];
        low = new int[vtx];
        ap = new boolean[vtx];
        time = 0;
        osc = 0;

        boolean[] vis = new boolean[vtx];
        articulation_point(graph, 0, -1, vis);

        int count = 0;
        for (int i = 0; i < vtx; i++) {
            if (ap[i] == true) {
                count++;
            }
        }
        System.out.println(count);
    }



    public static void articulation_point(ArrayList < Integer > [] graph, int src, int par, boolean[] vis) {
        disc[src] = low[src] = time;
        vis[src] = true;
        time++;

        for (int nbr: graph[src]) {
            if (nbr == par) {
                //do nothing
            } 
            else if (vis[nbr] == true) {
                //nbr is visited
                low[src] = Math.min(low[src], disc[nbr]);
            } 
            else if (vis[nbr] == false) {
                articulation_point(graph, nbr, src, vis);
                low[src] = Math.min(low[src], low[nbr]);

                //to check articulation point
                if (par == -1) {
                    //src is original source
                    osc++;

                    if (osc > 1) {
                        ap[src] = true;
                    }
                } 
                else if (disc[src] <= low[nbr]) {
                    ap[src] = true;
                }

                //to check bridge
                if(disc[src] < low[nbr]) {
                    System.out.println(src + "---" + nbr);
                }
            }
        }
    }
}