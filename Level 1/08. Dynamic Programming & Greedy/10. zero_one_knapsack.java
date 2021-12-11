import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = scn.nextInt();
        }

        for (int i = 0; i < n; i++) {
            wt[i] = scn.nextInt();
        }

        int cap = scn.nextInt();

        int mp = zero_one_ks(val, wt, cap);
        System.out.println(mp);
    }

    public static int zero_one_ks(int[] val, int[] wt, int cap) {
        int n = val.length;
        int[][] dp = new int[n][cap + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    //cap is 0
                    dp[i][j] = 0;
                } else if (i == 0) {
                    //only one element
                    if (j >= wt[i]) {
                        dp[i][j] = val[i];
                    }
                } else {
                    int exc = dp[i - 1][j];
                    int inc = 0;

                    if (j - wt[i] >= 0) {
                        inc = dp[i - 1][j - wt[i]] + val[i];
                    }

                    dp[i][j] = Math.max(inc, exc);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

}