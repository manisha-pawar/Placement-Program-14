import java.io.*;
import java.util.*;

public class Main {

    public static void radixSort(int[] arr) {
        // write code here 

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int d = 0;
        //count number of digits
        while (max > 0) {
            d++;
            max = max / 10;
        }

        int exp = 1;
        while (d > 0) {
            countSort(arr, exp);
            exp = exp * 10;

            d--;
        }
    }

    public static void countSort(int[] arr, int exp) {
        // write code here

        int[] farr = new int[10]; //freq array 0 to 9

        for (int i = 0; i < arr.length; i++) {
            int d = (arr[i] / exp) % 10;
            farr[d]++;
        }

        //generate prefix sum array of freq array
        int[] ps = new int[10];
        ps[0] = farr[0];

        for (int i = 1; i < farr.length; i++) {
            ps[i] = ps[i - 1] + farr[i];
        }

        //pos in this ps array are value based, not idx based
        for (int i = 0; i < farr.length; i++) {
            ps[i] -= 1;
        }

        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int d = (arr[i] / exp) % 10;
            int pos = ps[d];
            ans[pos] = arr[i];
            ps[d]--;
        }

        //copy ans array to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }

        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
    }

}