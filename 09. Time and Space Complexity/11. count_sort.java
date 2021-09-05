import java.io.*;
import java.util.*;

public class Main {

    public static void countSort(int[] arr, int min, int max) {
        //write your code here

        int len = max - min + 1;
        int[] farr = new int[len]; //freq array

        for (int i = 0; i < arr.length; i++) {
            farr[arr[i] - min]++;
        }

        //generate prefix sum array of freq array
        int[] ps = new int[len];
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
            int pos = ps[arr[i] - min];
            ans[pos] = arr[i];
            ps[arr[i] - min]--;
        }

        //copy ans array to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
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
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }

}