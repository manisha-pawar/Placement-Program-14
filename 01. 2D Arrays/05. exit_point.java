import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][]mat = new int[n][m];
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < m;j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        
        exitPoint(mat);
    }
    
    public static void exitPoint(int[][]mat) {
        //0 -> east
        //1 -> south
        //2 -> west
        //3 -> north
        
        int i = 0;
        int j = 0;
        int dir = 0; //initial direction is east
        int n = mat.length;
        int m = mat[0].length;
        
        while(i >= 0 && i < n && j >= 0 && j < m) {
            dir = (dir + mat[i][j]) % 4;
            
            if(dir == 0) {
                //east
                j++;
                
                if(j == m) {
                    j--;
                    break;
                }
            }
            else if(dir == 1) {
                //south
                i++;
                
                if(i == n) {
                    i--;
                    break;
                }
            }
            else if(dir == 2) {
                //west
                j--;
                
                if(j == -1) {
                    j++;
                    break;
                }
            }
            else if(dir == 3) {
                //north
                i--;
                
                if(i == -1) {
                    i++;
                    break;
                }
            }
        }
        
        System.out.println(i + "\n" + j);
        
    }
    
}