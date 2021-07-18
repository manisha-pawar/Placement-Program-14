import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][]mat = new int[n][n];
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < n;j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        
        saddlePoint(mat);
        
    }
    
    public static void saddlePoint(int[][]mat) {
       
        for(int i=0; i < mat.length;i++) {
            //find min elements and its col in ith row
            int min = mat[i][0] ;
            int col = 0;
            
            for(int j=1; j < mat[0].length;j++) {
                if(mat[i][j] < min ) {
                    min = mat[i][j];
                    col = j;
                }
            }
            
            boolean isSp = true;
            
            //if min is the maximum value of col
            for(int r = 0; r < mat.length;r++) {
                if(mat[r][col] > min) {
                    isSp = false;
                    break;
                }
            }
            
            if(isSp == true) {
                System.out.println(min);
                return;
            }
            
        }
        
        System.out.println("Invalid input");
       
    }

}