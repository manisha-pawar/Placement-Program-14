import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[]arr = new int[n];
        
        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }
        
        int[]qb = new int[n+1];
        
        Arrays.fill(qb,-1);
        
        int ways = csvj_mem(0,arr,qb);
        System.out.println(ways);
    }
    
    
    public static int csvj_rec(int src,int[]jumps) {
        if(src == jumps.length) {
            return 1;
        }
        
        int total = 0;
        for(int k = 1; k <= jumps[src] && src + k <= jumps.length;k++) {
            
            int ntodw = csvj_rec(src + k,jumps);
            
            total += ntodw;
        }
        
        return total;
    }
    
    
    public static int csvj_mem(int src,int[]jumps,int[]qb) {
        if(src == jumps.length) {
            return 1;
        }
        
        if(qb[src] != -1) {
            return qb[src];    
        }
        
        int total = 0;
        
        for(int k=1; k <= jumps[src] && src + k <= jumps.length;k++) {
            int ntodw = csvj_mem(src + k,jumps,qb);
            total += ntodw;
        }
        
        qb[src] = total;
        
        return total;
        
    }

}