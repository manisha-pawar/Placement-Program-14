import java.io.*;
import java.util.*;

public class Main {

    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        //write your code here

        int n = a.length;
        int m = b.length;

        int[] marr = new int[n + m]; //merged array

        int i = 0; //a
        int j = 0; //b
        int k = 0; //marr

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                marr[k] = a[i];
                i++;
                k++;
            } else {
                marr[k] = b[j];
                j++;
                k++;
            }
        }

        //check if elements of first array are left
        while (i < n) {
            marr[k] = a[i];
            k++;
            i++;
        }

        //check if elements of second array are left
        while (j < m) {
            marr[k] = b[j];
            k++;
            j++;
        }

        return marr;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a, b);
        print(mergedArray);
    }

}