import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        // int[]qb = new int[n+1];
        // System.out.println(csvj_mm_mem(0,arr,qb));

        System.out.println(csvj_mm_tab(arr));
    }

    public static int csvj_mm_tab(int[] jumps) {
        int n = jumps.length;
        int[] dp = new int[n + 1];

        //dp[i] -> min moves from i to n

        dp[n] = 0; //n to n min moves = 0

        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;

            for (int k = 1; k <= jumps[i] && i + k <= n; k++) {
                int nbr = i + k;
                int mmntod = dp[nbr];

                if (mmntod < min) {
                    min = mmntod;
                }
            }

            if (min == Integer.MAX_VALUE) {
                dp[i] = Integer.MAX_VALUE;
            } else {
                dp[i] = min + 1;
            }
        }

        return dp[0];
    }

    public static int csvj_mm_mem(int src, int[] jumps, int[] qb) {
        if (src == jumps.length) {
            return 0;
        }

        if (qb[src] != 0) {
            return qb[src];
        }

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= jumps[src] && src + k <= jumps.length; k++) {
            int mmntod = csvj_mm_mem(src + k, jumps, qb); //min moves from nbr to dest

            if (mmntod < min) {
                min = mmntod;
            }
        }

        if (min == Integer.MAX_VALUE) {
            qb[src] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        } else {
            qb[src] = min + 1;
            return min + 1;
        }

    }

}