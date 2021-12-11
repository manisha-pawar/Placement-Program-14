import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][]mat = new int[n][n];
        
        for(int i=0;i < n; i++) {
            for(int j=0; j < n;j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        
        diagonalTraversal(mat);
    }
    
    public static void diagonalTraversal(int[][]mat) {
        
        //to select diagonal
        for(int d=0;d < mat.length;d++) {
            for(int i = 0,j = d;j < mat.length ; i++,j++) {
                System.out.println(mat[i][j]);
            }
        }
    }

}