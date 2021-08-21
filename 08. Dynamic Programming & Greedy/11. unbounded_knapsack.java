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

	        int mp = unbounded_ks(val, wt, cap);
	        System.out.println(mp);
	    }

	    public static int unbounded_ks(int[] val, int[] wt, int cap) {
	        int[] dp = new int[cap + 1];

	        //dp[i] -> max profit generated if cap is 'i'
	        dp[0] = 0;

	        for (int i = 1; i < dp.length; i++) {
	            int max = 0;
	            for (int j = 0; j < val.length; j++) {
	                int rem_cap = i - wt[j];

	                if (rem_cap >= 0) {
	                    int profit = dp[rem_cap] + val[j];

	                    if (profit > max) {
	                        max = profit;
	                    }
	                }
	            }

	            dp[i] = max;
	        }

	        return dp[cap];

	    }

	}