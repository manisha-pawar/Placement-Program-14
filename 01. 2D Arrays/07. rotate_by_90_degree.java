import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][]mat = new int[n][n];
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < n;j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        
        rotateBy90(mat);
        display(mat);
    }
    
    public static void transpose(int[][]mat) {
        int n = mat.length;
        
        for(int i=0; i < n;i++) {
            for(int j=i; j < n;j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }    
    }
    
    public static void columnReversal(int[][]mat) {
        int lo = 0;
        int hi = mat[0].length-1;
        
        while(lo < hi) {
            for(int i=0; i < mat.length;i++) {
                int temp = mat[i][lo];
                mat[i][lo] = mat[i][hi];
                mat[i][hi] = temp;
            }
            lo++;
            hi--;
        }
    }
    
    public static void rotateBy90(int[][]mat) {
        
        //transpose
        transpose(mat);
        
        //column-reversal
        columnReversal(mat);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}