import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        System.out.println(ways(n,k));
        
    }   
    
    
    public static int ways(int n,int k) {
        if(n == 1) {
            return k;
        }
        
        //smallest problem, n = 2
        int osc = k; //last two fences have same color
        int odc = k*(k-1); //last two fences have diff color
        
        for(int i = 3; i <= n;i++) {
            int nsc = odc;
            int ndc = (osc + odc) * (k-1);
            
            osc = nsc;
            odc = ndc;
        }
        
        return osc + odc;
    }
}