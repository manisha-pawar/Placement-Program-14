import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x  = scn.nextInt();
        int n = scn.nextInt();
        
        int ans = power(x,n);
        System.out.println(ans);
    }

    public static int power(int x, int n){
        if(n == 0) {
            return 1;
        }
        
        int xpnb2 = power(x,n/2); //x raised to the power n/2
        
        int xpn = 1;
        
        if(n % 2 == 0) {
            xpn = xpnb2 * xpnb2;
        }
        else {
            xpn = xpnb2 * xpnb2 * x;
        }
        
        return xpn;
    }

}