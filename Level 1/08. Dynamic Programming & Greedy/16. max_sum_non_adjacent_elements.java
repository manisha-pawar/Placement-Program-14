import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {   
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[]arr = new int[n];
        
        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }
        
        System.out.println(maxSumNASS(arr));
    }
    
    public static int maxSumNASS(int[]arr) {
        int oexc = 0;
        int oinc = 0;
        
        for(int i=0; i < arr.length;i++) {
            int ninc = oexc + arr[i];
            int nexc = Math.max(oexc,oinc);
            
            oinc = ninc;
            oexc = nexc;
        }
        
        return Math.max(oexc,oinc);
    }
}