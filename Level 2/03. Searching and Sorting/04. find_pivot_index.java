import java.util.*;
import java.io.*;

public class Main {

    public static int pivot_index(int[]arr) {
        //write your code here
        int sum = 0;
        
        for(int val : arr) {
            sum += val;
        }
        
        int rsum = sum;
        int lsum = 0;
        
        for(int i = 0; i < arr.length;i++) {
            rsum -= arr[i];
            
            if(lsum == rsum) {
                return i;
            }
            
            lsum += arr[i];
        }
        
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < arr.length;i++) {
            arr[i] = scn.nextInt();
        }

        int pi = pivot_index(arr);
        System.out.println(pi);
    }
}