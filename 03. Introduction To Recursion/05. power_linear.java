import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        
        int ans = power(x,n);
        System.out.println(ans);
    }

    public static int power(int x, int n){
        if(n == 0) {
            return 1;
        }
        
        int xpnm1 = power(x,n-1); //x raised to the power n-1
        int xpn = x * xpnm1; //x raised to the power n
        
        return xpn;
    }

}