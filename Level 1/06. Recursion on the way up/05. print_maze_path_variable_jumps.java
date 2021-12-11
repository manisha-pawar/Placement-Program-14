import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int m=scn.nextInt();
        
        printMazePaths(0,0,n-1,m-1,"");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        
        //horizontal moves
        for(int k=1; sc + k <= dc;k++) {
            printMazePaths(sr,sc + k,dr,dc,psf + "h" + k);
        }
        
        //vertical moves
        for(int k=1; sr + k <= dr;k++) {
            printMazePaths(sr + k,sc,dr,dc,psf + "v" + k);
        }
        
        //diagonal moves
        for(int k=1; sr + k <= dr && sc + k <= dc;k++) {
            printMazePaths(sr + k,sc + k,dr,dc,psf + "d" + k);
        }
    }

}