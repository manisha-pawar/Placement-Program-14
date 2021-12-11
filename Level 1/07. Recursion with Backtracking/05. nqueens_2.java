import java.util.*;

public class Main {
    public static void main(String[]args) {
        
        Scanner scn = new Scanner(System.in);
        
        int N = scn.nextInt();
        
        nqueens(0,"",N);
    }
    
    public static void nqueens(int row,String psf,int N) {
        if(row == N) {
            System.out.println(psf);
            return;
        }
        
        for(int col = 0; col < N;col++) {
            nqueens(row+1,psf + row + col + "-",N);
        }
    }
}