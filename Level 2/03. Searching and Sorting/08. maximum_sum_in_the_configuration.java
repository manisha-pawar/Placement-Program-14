import java.util.*;

public class Main {

    public static int maximise(int[]arr) {
     
       int sum = 0;
       int Si = 0; //S0
       
       for(int i=0; i < arr.length;i++) {
           sum += arr[i];
           Si += arr[i]*i;
       }
       
       int max = Si;
       int n = arr.length;
       
       for(int i=0; i < arr.length-1;i++) {
           int Sip1 = Si + sum - n * arr[n-1-i];
           
           if(Sip1 > max) {
               max = Sip1;
           }
           
           Si = Sip1;
       }
       
       return max;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr);
        System.out.println(ans);
    }
}