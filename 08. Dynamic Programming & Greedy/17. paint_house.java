import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][]cost = new int[n][3];
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < 3;j++) {
                cost[i][j] = scn.nextInt();
            }
        }
        
        System.out.println(minCost(cost));
    }
    
    public static int minCost(int[][]cost) {
        int n = cost.length;
        
        int or = 0;
        int og = 0;
        int ob = 0;
        
        for(int i=0; i < n;i++) {
            
            int nr = Math.min(og,ob) + cost[i][0];
            int ng = Math.min(or,ob) + cost[i][1];
            int nb = Math.min(or,og) + cost[i][2];
            
            or = nr;
            og = ng;
            ob = nb;
        }
        
        return Math.min(Math.min(or,og),ob);
    }
}