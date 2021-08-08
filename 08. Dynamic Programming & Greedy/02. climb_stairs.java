import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        // int[]qb = new int[n+1];
        // System.out.println(cs_mem(n,qb));
        
        System.out.println(cs_tab(n));
    
    }
    
    public static int cs_rec(int n) {
        if(n == 0) {
            return 1;
        }
        
        if(n < 0) {
            return 0;  
        }
        
        int ways = cs_rec(n-1) + cs_rec(n-2) + cs_rec(n-3);
        
        return ways;
    }
    
    public static int cs_mem(int n,int[]qb) {
        if(n == 0) {
            return 1;
        }
        
        if(n < 0) {
            return 0;  
        }
        
        if(qb[n] != 0) {
            return qb[n];
        }
        
        int ways = cs_mem(n-1,qb) + cs_mem(n-2,qb) + cs_mem(n-3,qb);
        qb[n] = ways;
        
        return ways;
    }
    
    
    
    public static int cs_tab(int n) {
        int[]dp = new int[n+1];
        
        //dp[i] -> i to 0 ways
        
        dp[0] = 1;
        
        for(int i=1; i <= n;i++) {
            
            if(i == 1) {
                dp[i] = dp[i-1];
            }
            else if(i == 2) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            else {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        
        return dp[n];
    }
    
}