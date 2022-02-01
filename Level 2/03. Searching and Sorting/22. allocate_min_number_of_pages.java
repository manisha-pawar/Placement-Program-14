import java.util.*;
import java.io.*;

public class Main {

  public static int minPages(int[]arr, int m) {
        int max = arr[0];
        int sum = 0;
        
        for(int val : arr) {
            sum += val;
            max = Math.max(max,val);
        }
        
        int lo = max;
        int hi = sum;
        int ans = 0;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            
            if(isPossible(arr,mid,m) == true) {
                ans = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        
        return ans;
  }
  
  public static boolean isPossible(int[]arr,int mid,int m) {
      int st = 1;
      int sum = 0;
      
      for(int i=0; i < arr.length;i++) {
          sum += arr[i];
          
          if(sum > mid) {
              st++;
              sum = arr[i];
          }
      }
      
      return st <= m;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int m = scn.nextInt();

    int ans = minPages(arr, m);
    System.out.println(ans);
  }
}