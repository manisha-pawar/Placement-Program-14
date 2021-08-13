import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] cost = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cost[i][j] = scn.nextInt();
            }
        }

        // int[][]qb = new int[n][m];
        // System.out.println(minCost_mem(0,0,cost,qb));

        System.out.println(minCost_tab(cost));
    }

    public static int minCost_tab(int[][] cost) {
        int n = cost.length;
        int m = cost[0].length;

        int[][] dp = new int[n][m];

        //dp[i][j] -> i,j to n-1,m-1 min cost

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    //no nbr
                    dp[i][j] = cost[i][j];
                } else if (i == n - 1) {
                    //only horizontal nbr
                    dp[i][j] = dp[i][j + 1] + cost[i][j];
                } else if (j == m - 1) {
                    //only vertical
                    dp[i][j] = dp[i + 1][j] + cost[i][j];
                } else {
                    //both nbr -> horizontal & vertical
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + cost[i][j];
                }
            }
        }


        return dp[0][0];
    }

    public static int minCost_mem(int sr, int sc, int[][] cost, int[][] qb) {
        if (sr == cost.length - 1 && sc == cost[0].length - 1) {
            return cost[sr][sc];
        }

        if (sr >= cost.length || sc >= cost[0].length) {
            return Integer.MAX_VALUE;
        }

        if (qb[sr][sc] != 0) {
            return qb[sr][sc];
        }

        int hntodmc = minCost_mem(sr, sc + 1, cost, qb);
        int vntodmc = minCost_mem(sr + 1, sc, cost, qb);

        int stodmc = Math.min(hntodmc, vntodmc) + cost[sr][sc];
        qb[sr][sc] = stodmc;

        return stodmc;
    }

}