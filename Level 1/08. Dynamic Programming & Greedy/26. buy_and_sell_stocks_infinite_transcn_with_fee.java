import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]prices = new int[n];
        
        for(int i=0; i < n;i++) {
            prices[i] = scn.nextInt();
        }
        
        int fee = scn.nextInt();
        
        int ans = infinite_transactions_with_fee(prices,fee);
        System.out.println(ans);
    }
    
    
    public static int infinite_transactions_with_fee(int[]prices,int fee) {
        int obsp = -prices[0]; //old buy state profit
        int ossp = 0; //old sell state profit
        
        for(int i=1; i < prices.length;i++) {
            int nbsp = Math.max(obsp,ossp - prices[i]); //new buy state profit
            int nssp = Math.max(ossp, obsp + prices[i] - fee); //new sell state profit
            
            obsp = nbsp;
            ossp = nssp;
        }
        
        return ossp;
    }

}