import java.util.*;

public class Main {
    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        
        nqueens(0,0,"",0,N);
    }
    
    
    public static void nqueens(int r,int c,String psf,int qpsf,int N) {
        if(c == N) {
            r = r+1;
            c = 0;
        }
        
        if(r == N) {
            if(qpsf == N) {
                System.out.println(psf);
            }
            return;
        }
        
        //yes
        nqueens(r,c+1,psf + r + c + "-",qpsf + 1,N);
        
        //no
        nqueens(r,c+1,psf,qpsf,N);
    }
}