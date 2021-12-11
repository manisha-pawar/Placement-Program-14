import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        boolean ans = targetSumSubset(arr, target);
        System.out.println(ans);
    }

    public static boolean targetSumSubset(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (j == 0) {
                    //target 0
                    dp[i][j] = true;
                } else if (i == 0) {
                    //single element
                    if (arr[i] <= target) {
                        dp[i][arr[i]] = true;
                    }
                } else {
                    boolean exc = dp[i - 1][j];
                    boolean inc = false;

                    if (j - arr[i] >= 0) {
                        inc = dp[i - 1][j - arr[i]];
                    }

                    dp[i][j] = inc || exc;
                }
            }
        }


        return dp[dp.length - 1][dp[0].length - 1];

    }
}