import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here
      
      KsortedArray(arr,k);
   }
   
   public static void KsortedArray(int[]arr,int k)  {
       
       PriorityQueue<Integer>pq = new PriorityQueue<>(); //smaller value has higher priority
       
       //add starting k+1 elements in pq
       for(int i=0; i <= k;i++) {
           pq.add(arr[i]);
       }
       
       for(int i=k+1; i < arr.length;i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]);
       }
       
       
       //print remaining k+1 elements
       while(pq.size() > 0) {
           System.out.println(pq.remove());
       }
       
       
   }
   

}