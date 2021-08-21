import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[]coins = new int[n];
        
        for(int i=0; i < coins.length;i++) {
            coins[i] = scn.nextInt();
        }
        
        int amount = scn.nextInt();
        
        int ways = ccc(coins,amount);
        System.out.println(ways);
    }
    

    public static int ccc(int[]coins,int amt) {
        int[]dp = new int[amt+1];
        
        dp[0] = 1;
        
        for(int i=0; i < coins.length;i++) {
            for(int j = coins[i]; j <= amt;j++) {
                int rem_amt = j - coins[i];
                
                dp[j] += dp[rem_amt];
            }
        }
        
        return dp[amt];
    }
}