import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][]cost = new int[n][m];
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < m;j++) {
                cost[i][j] = scn.nextInt();
            }
        }
        
        System.out.println(minCost(cost));
    }
    
    public static int minCost(int[][]cost) {
        int n = cost.length;
        int m = cost[0].length;
        
        int[][]dp = new int[n][m];
        
        int omin = Integer.MAX_VALUE; //old min
        int osmin = Integer.MAX_VALUE; //old second min
        
        for(int i=0; i < dp.length;i++) {
            
            int cmin = Integer.MAX_VALUE; //current min
            int csmin = Integer.MAX_VALUE; //current second min
        
            for(int j=0; j < dp[0].length;j++) {
                if(i == 0) {
                    dp[i][j] = cost[i][j];
                }
                else {
                    //try to use omin
                    if(dp[i-1][j] != omin) {
                        dp[i][j] = cost[i][j] + omin;
                    }
                    else {
                        dp[i][j] = cost[i][j] + osmin;
                    }
                }
                
                
                //maintain cmin and csmin
                if(dp[i][j] < cmin) {
                    csmin = cmin;
                    cmin = dp[i][j];
                }
                else if(dp[i][j] < csmin) {
                    csmin = dp[i][j];
                }
            }
            
            
            omin = cmin;
            osmin = csmin;
        }
            
        return omin;
     
    }
}