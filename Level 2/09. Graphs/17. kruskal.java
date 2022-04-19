import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int[][] edges = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(st[0]);
            edges[i][1] = Integer.parseInt(st[1]);
            edges[i][2] = Integer.parseInt(st[2]);
        }

        System.out.println(minCostToSupplyWater(v, edges));
    }

    static int[] parent;
    static int[] rank;

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        int sl = find(parent[x]);
        parent[x] = sl; //path compression
        return sl;
    }

    public static boolean union(int u, int v) {
        int sl1 = find(u);
        int sl2 = find(v);

        if (sl1 != sl2) {
            //merging
            if (rank[sl1] < rank[sl2]) {
                parent[sl1] = sl2;
            } else if (rank[sl2] < rank[sl1]) {
                parent[sl2] = sl1;
            } else {
                parent[sl1] = sl2;
                rank[sl2]++;
            }

            return true;
        } else {
            return false;
        }
    }

    public static int minCostToSupplyWater(int n, int[][] pipes) {
        Arrays.sort(pipes, (a, b) - > {
            //-ve -> a < b
            //+ve -> a > b
            //0 -> a == b
            return a[2] - b[2];
        });


        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int mincost = 0;
        for (int i = 0; i < pipes.length; i++) {
            int u = pipes[i][0];
            int v = pipes[i][1];
            int wt = pipes[i][2];

            if (union(u, v) == true) {
                //u,v edge is used for creating mst
                mincost += wt;
            }
        }

        return mincost;
    }

}