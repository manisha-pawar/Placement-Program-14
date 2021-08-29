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
        
        System.out.println(one_transaction(prices));
    }
    
    public static int one_transaction(int[]prices) {
        
        int lmsf = Integer.MAX_VALUE; //left min so far
        int opr = 0; //overall best profit
        
        for(int i=0; i < prices.length;i++) {
            if(prices[i] < lmsf) {
                lmsf = prices[i];
            }
            
            int pr  = prices[i] - lmsf; //ith day is selling day
            
            if(pr > opr) {
                opr = pr;
            }
        }
        
        return opr;
    }

}