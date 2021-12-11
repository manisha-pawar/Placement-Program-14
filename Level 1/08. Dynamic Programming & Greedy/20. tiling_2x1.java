import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        System.out.println(ways(n));
    }
    
    public static int ways(int n) {
        int[]dp = new int[n+1];
        
        //dp[i] -> 2*i area ways
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i <= n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}