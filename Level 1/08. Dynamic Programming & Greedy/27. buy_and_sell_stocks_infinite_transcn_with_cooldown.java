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
        
        int ans = infinite_trans_with_cooldown(prices);
        System.out.println(ans);
    }
    
    public static int infinite_trans_with_cooldown(int[]prices) {
        int ob = -prices[0]; //old buy state profit
        int os = 0; //old sell state profit
        int oc = 0; //old cooldown state profit
        
        for(int i=1; i < prices.length;i++) {
            
            int nb = Math.max(ob, oc - prices[i]);
            int ns = Math.max(os, ob + prices[i]);
            int nc = Math.max(oc, os + 0);
            
            ob = nb;
            os = ns;
            oc = nc;
        }
        
        return os;
    }

}