import java.io.*;
import java.util.*;

public class Main {

    public static int perfect_friends(ArrayList < Integer > [] graph) {
        boolean[] vis = new boolean[graph.length];
        ArrayList < Integer > comp_size = new ArrayList < > ();

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == false) {
                scs = 0; //single comp size
                travel(i, graph, vis);
                comp_size.add(scs);
            }
        }

        int count = 0;
        for (int i = 0; i < comp_size.size(); i++) {
            for (int j = i + 1; j < comp_size.size(); j++) {
                int cis = comp_size.get(i);
                int cjs = comp_size.get(j);

                count += cis * cjs;
            }
        }

        return count;

    }

    static int scs = 0;
    public static void travel(int src, ArrayList < Integer > [] graph, boolean[] vis) {
        scs++;
        vis[src] = true;


        for (int nbr: graph[src]) {
            if (vis[nbr] == false) {
                travel(nbr, graph, vis);
            }
        }
    }

    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        ArrayList < Integer > [] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList < > ();
        }

        while (k-- > 0) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        int ways = perfect_friends(graph);
        System.out.println(ways);
    }

}