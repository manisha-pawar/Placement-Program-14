import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int N = scn.nextInt();
        
        int[][]chess = new int[N][N];
        
        printNQueens(chess,"",0);
        
    }

    public static boolean isQueenSafe(int[][]chess,int r,int c) {
        //col check
        for(int i = r-1; i >= 0; i--) {
            if(chess[i][c] == 1) {
                return false;
            }
        }
        
        //top right diagonal
        for(int i = r-1,j = c+1; i >= 0 && j < chess.length;i--,j++) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        
        //top left diagonal
        for(int i = r-1,j = c-1; i >= 0 && j >= 0; i--,j--) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void printNQueens(int[][] chess, String psf, int row) {
        if(row == chess.length) {
            System.out.println(psf + ".");
            return;
        }
        
        for(int col = 0; col < chess.length;col++) {
            
            if(isQueenSafe(chess,row,col) == true) {
                //place 
                chess[row][col] = 1;
                
                printNQueens(chess,psf + row + "-" + col + ", ",row+1);
                
                //unplace
                chess[row][col] = 0;
            }
        }
    }
}