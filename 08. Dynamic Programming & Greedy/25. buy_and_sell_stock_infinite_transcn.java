import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[]prices = new int[n];
        
        for(int i=0; i < prices.length;i++) {
            prices[i] = scn.nextInt();
        }
        
        int ans = infinite_transaction(prices);
        System.out.println(ans);
    }
    
    public static int infinite_transaction(int[]prices) {
        int acc = 0; //overall profit accumulator
        
        for(int i=0; i < prices.length - 1;i++) {
            if(prices[i] < prices[i+1]) {
                acc += (prices[i+1] - prices[i]);
            }
        }
        
        return acc;
    }

}