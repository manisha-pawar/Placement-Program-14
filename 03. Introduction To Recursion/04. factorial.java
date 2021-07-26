import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = factorial(n);
        System.out.println(ans);
    }

    public static int factorial(int n){
        if(n == 0) {
            //0! = 1
            return 1;
        }
        
        int fnm1 = factorial(n-1); //factorial of n-1
        int fn = n*fnm1; //factorial of n
        
        return fn;
    }

}