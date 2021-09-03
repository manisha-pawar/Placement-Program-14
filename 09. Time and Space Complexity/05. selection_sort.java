import java.io.*;
import java.util.*;

public class Main {

  public static void selectionSort(int[] arr) {
    //write your code here
    
    int n = arr.length;
    
    for(int itr = 1; itr < n;itr++) {
        int i = itr-1;
        int mi = i; //min idx
        
        for(int j = i+1; j < n;j++) {
            if(isSmaller(arr,j,mi) == true) {
                mi = j;
            }
        }
        
        //swap i and mi
        swap(arr,i,mi);
    }
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // return true if ith element is smaller than jth element
  public static boolean isSmaller(int[] arr, int i, int j) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
    }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    selectionSort(arr);
    print(arr);
  }

}