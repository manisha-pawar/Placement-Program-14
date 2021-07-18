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
        
        int target = scn.nextInt();
        
        search(mat,target);
    }
    
    public static void search(int[][]mat,int target) {
        int r = 0;
        int c = mat[0].length-1;
        
        while(r < mat.length && c >= 0) {
            if(mat[r][c] == target) {
                System.out.println(r + "\n" + c);
                return;
            }
            else if(mat[r][c] > target) {
                c--;
            }
            else {
                r++;
            }
        }
        
        System.out.println("Not Found");
        
    }
    
}