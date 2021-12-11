import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] gold = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                gold[i][j] = scn.nextInt();
            }
        }

        // int omax = Integer.MIN_VALUE;
        // int[][]qb = new int[n][m];

        // //we have multiple sources to start with
        // for(int i=0; i < n;i++) {
        //     int ans = maxGold_mem(i,0,gold,qb);
        //     if(omax < ans) {
        //         omax = ans;
        //     }
        // }

        // System.out.println(omax);

        System.out.println(maxGold_tab(gold));

    }


    public static int maxGold_mem(int r, int c, int[][] gold, int[][] qb) {
        if (r < 0 || r >= gold.length) {
            return Integer.MIN_VALUE;
        }

        if (c == gold[0].length - 1) {
            return gold[r][c];
        }

        if (qb[r][c] != 0) {
            return qb[r][c];
        }

        int f1 = maxGold_mem(r - 1, c + 1, gold, qb);
        int f2 = maxGold_mem(r, c + 1, gold, qb);
        int f3 = maxGold_mem(r + 1, c + 1, gold, qb);

        int ans = Math.max(Math.max(f1, f2), f3) + gold[r][c];
        qb[r][c] = ans;

        return ans;
    }


     public static int maxGold_tab(int[][] gold) {

        int n = gold.length;
        int m = gold[0].length;

        int[][] dp = new int[n][m];

        //dp[i][j] -> max gold collecting if we start digging from i,j to last last col


        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {

                if (j == m - 1) {
                    //no nbr, because last col
                    dp[i][j] = gold[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + gold[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + gold[i][j];
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j + 1]), dp[i - 1][j + 1]) + gold[i][j];
                }
            }
        }

        int omax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (dp[i][0] > omax) {
                omax = dp[i][0];
            }
        }

        return omax;
    }


}