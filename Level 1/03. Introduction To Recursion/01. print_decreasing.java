import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        printDecreasing(n); //expectation -> n n-1 n-2 n-3...1
    }

    public static void printDecreasing(int n){
        if(n == 0) {
            return;
        }
        
        System.out.println(n);
        
        //faith -> n-1 n-2 n-3...1
        printDecreasing(n-1);
    }

}